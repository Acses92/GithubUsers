package ru.kravchenkoanatoly.githubusers.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import ru.kravchenkoanatoly.githubusers.common.base.BaseFragment
import ru.kravchenkoanatoly.githubusers.common.models.Status
import ru.kravchenkoanatoly.githubusers.common.utils.hide
import ru.kravchenkoanatoly.githubusers.common.utils.show
import ru.kravchenkoanatoly.githubusers.search.databinding.SearchFragmentBinding

@AndroidEntryPoint
class SearchFragment: BaseFragment(R.layout.search_fragment) {
    private var _binding: SearchFragmentBinding? = null
    private val binding get()= _binding!!
    private val viewModel by viewModels<SearchViewModel>()
    private lateinit var githubUsersAdapter: GithubUsersAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SearchFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchViewListener()
        observeState()
        setupRecyclerAdapter()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeState(){
        viewModel.userListState.onEach { state->
            when(state.status) {
                is Status.Idle -> {
                    binding.progressBar.hide()
                    val data = state.data
                    if(!data.isNullOrEmpty()) {
                        binding.githubUserRecyclerView.show()
                        binding.requestInformationTextview.hide()
                        githubUsersAdapter.submitList(data)

                    } else{
                        binding.githubUserRecyclerView.hide()
                        githubUsersAdapter.submitList(null)
                        binding.requestInformationTextview.text = getString(R.string.empty_result_text)
                        binding.requestInformationTextview.show()
                    }
                }

                is Status.Loading -> {
                    binding.progressBar.show()
                    binding.requestInformationTextview.hide()
                }

                is Status.Failure -> {
                    Toast.makeText(this.context, "Error", Toast.LENGTH_LONG)
                        .show()

                }

                is Status.EmptyState -> {
                    binding.progressBar.hide()
                    binding.requestInformationTextview.text = getString(R.string.send_request_text)
                    binding.requestInformationTextview.show()
                }
            }
        }.repeatOnCreated()
    }

    private fun setupRecyclerAdapter() {
        githubUsersAdapter = GithubUsersAdapter(
            onUserClicked = viewModel::onUserClicked,
            onUserFollowers = viewModel::getUserFollowers
            )
        with(binding.githubUserRecyclerView) {
            adapter = githubUsersAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }

    private fun searchViewListener() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(userName: String?): Boolean{
                if(userName!=null){
                    viewModel.getUserListSearch(userName)
                }
                return false
            }
            /**
             * реал-тайм поиск. так делать правильнее, но натыкаемся на рэйт лимиты
             * при этом, для авторизованных пользователей, они меньше
             * в реальном проекте это решается на уровне api
             */
            override fun onQueryTextChange(userName: String?): Boolean {
                /*
                if(userName!=null){
                    viewModel.getUserListSearch(userName)
                }*/
                return false
            }

        })
    }
}