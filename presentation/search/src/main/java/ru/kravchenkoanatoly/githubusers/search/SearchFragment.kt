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
import ru.kravchenkoanatoly.githubusers.common.utils.PaginationScrollListener
import ru.kravchenkoanatoly.githubusers.common.utils.hide
import ru.kravchenkoanatoly.githubusers.common.utils.show
import ru.kravchenkoanatoly.githubusers.search.databinding.SearchFragmentBinding

@AndroidEntryPoint
class SearchFragment : BaseFragment(R.layout.search_fragment) {
    private var _binding: SearchFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<SearchViewModel>()
    private lateinit var githubUsersAdapter: GithubUsersAdapter
    var isLoading = false
    var userName: String = ""


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
        setUpScrollListener()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeState() {
        viewModel.userListState.onEach { state ->
            when (state.status) {
                is Status.Idle -> {
                    binding.progressBar.hide()
                    val data = state.data
                    if (!data.isNullOrEmpty()) {
                        binding.githubUserRecyclerView.show()
                        binding.requestInformationTextview.hide()
                        githubUsersAdapter.submitList(data)

                    } else {
                        binding.githubUserRecyclerView.hide()
                        githubUsersAdapter.submitList(null)
                        binding.requestInformationTextview.text =
                                getString(R.string.empty_result_text)
                        binding.requestInformationTextview.show()
                    }
                    isLoading = false
                }

                is Status.Loading -> {
                    binding.progressBar.show()
                    binding.requestInformationTextview.hide()
                    isLoading = true
                }

                is Status.Failure -> {
                    Toast.makeText(this.context, "Error", Toast.LENGTH_LONG)
                        .show()
                    isLoading = false

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
            override fun onQueryTextSubmit(text: String?): Boolean {
                /**
                 * прекрассный баг эмулятора, иллюстрирующий разработку под андроид
                 * если вводить текст с реальной клавиатуры - метод вызывается дважды
                 * если, с виртуальной клавитатуры эмулятора - один раз.
                 * воспризводится на эмулятора api 30-32, mac и win
                 * при наличии rateLimit'а в 60 запросов в час и страниуе в 30 записей
                 * на ручки https://api.github.com/users/nnnn очень увлекательно
                 *
                 */
                if (text != null) {
                    userName = text
                    //добавить очистку бд при старте
                    viewModel.viewModelClearRequestCache()
                    viewModel.getUserListSearch(userName)
                    viewModel.getMaxUsersFromRequest(userName)
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

    /**
     * метод, обеспечивающий пагинацию. работает, но опять же, ограничение API в 10
     * запросов на 10 минут, для ручки  https://api.github.com/search/users/nnnn
     */
    private fun setUpScrollListener() {
        with(binding) {
            githubUserRecyclerView.addOnScrollListener(object :
                PaginationScrollListener(githubUserRecyclerView.layoutManager as LinearLayoutManager) {
                override fun loadMoreItems() = viewModel.getUserListSearch(userName)

                override fun isLastPage(): Boolean {
                    if (viewModel.maxPages == viewModel.currentPage) {
                        return true
                    } else {
                        return false
                    }
                }

                override fun isLoading(): Boolean = isLoading
            }
            )
        }
    }
}