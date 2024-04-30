package ru.kravchenkoanatoly.githubusers.detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import ru.kravchenkoanatoly.githubusers.common.base.BaseFragment
import ru.kravchenkoanatoly.githubusers.common.models.Status
import ru.kravchenkoanatoly.githubusers.common.utils.args
import ru.kravchenkoanatoly.githubusers.common.utils.hide
import ru.kravchenkoanatoly.githubusers.common.utils.show
import ru.kravchenkoanatoly.githubusers.detail.databinding.DetailFragmentBinding
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class UserDetailFragment : BaseFragment(R.layout.detail_fragment) {
    companion object {
        const val USERNAME_DETAIL_FRAGMENT_KEY = "USERNAME_DETAIL_FRAGMENT_KEY"
        const val USER_AVATAR_DETAIL_FRAGMENT_KEY = "USER_AVATAR_DETAIL_FRAGMENT_KEY"
        const val USER_ID_DETAIL_FRAGMENT_KEY = "USER_ID_DETAIL_FRAGMENT_KEY"
        const val USER_DETAIL_FRAGMENT_TAG = "USER_DETAIL_FRAGMENT_TAG"
    }

    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!
    private val userName: String by args<String>(USERNAME_DETAIL_FRAGMENT_KEY)
    private val userId: Int by args<Int>(USER_ID_DETAIL_FRAGMENT_KEY)
    private val userAvatar: String by args<String>(USER_AVATAR_DETAIL_FRAGMENT_KEY)
    private lateinit var repositoriesAdapter: RepositoriesAdapter

    @Inject
    internal lateinit var factory: UserDetailViewModelFactory
    private val viewModel: UserDetailViewModel by lazy { factory.get(userName, userAvatar, userId) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            findNavController().popBackStack()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.tag(USER_DETAIL_FRAGMENT_TAG).d(userName)
        userInfoFill()
        viewModel.getUsersRepositories()
        setupAdapter()
        repositoriesObserver()
    }

    private fun userInfoFill() {
        with(binding.userInfo) {
            userIdTextview.text = getString(R.string.user_id_text_view, userId)
            userNameTextview.text = getString(R.string.user_name_text_view, userName)
            context?.let {
                Glide.with(it).load(userAvatar).centerCrop()
                    .error(R.drawable.avatar)
                    .placeholder(R.drawable.avatar).into(avatarImageView)
            }
        }

    }

    private fun setupAdapter() {
        repositoriesAdapter = RepositoriesAdapter()
        with(binding.usersProjectRecyclerView) {
            adapter = repositoriesAdapter
            layoutManager = LinearLayoutManager(context)
        }

    }

    private fun repositoriesObserver() {
        viewModel.repositoriesList.onEach { state ->
            when (state.status) {
                is Status.Idle -> {
                    binding.emptyRepositoriesTextView.hide()
                    val data = state.data
                    if (!data.isNullOrEmpty()) {
                        repositoriesAdapter.submitList(data)
                    }
                }

                else -> {
                    binding.emptyRepositoriesTextView.show()
                }
            }
        }.repeatOnStarted()
    }


}