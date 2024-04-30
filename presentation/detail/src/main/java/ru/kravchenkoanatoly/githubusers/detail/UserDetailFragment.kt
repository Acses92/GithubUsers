package ru.kravchenkoanatoly.githubusers.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import ru.kravchenkoanatoly.githubusers.common.base.BaseFragment
import ru.kravchenkoanatoly.githubusers.detail.databinding.DetailFragmentBinding
import javax.inject.Inject

@AndroidEntryPoint
class UserDetailFragment: BaseFragment(R.layout.detail_fragment) {
    companion object{
        const val USERNAME_DETAIL_FRAGMENT_KEY = "USERNAME_DETAIL_FRAGMENT_KEY"
        const val USER_AVATAR_DETAIL_FRAGMENT_KEY = "USER_AVATAR_DETAIL_FRAGMENT_KEY"
        const val USER_ID_DETAIL_FRAGMENT_KEY = "USER_ID_DETAIL_FRAGMENT_KEY"
    }

    private var _binding: DetailFragmentBinding? = null
    private val binding get() = _binding!!


    @Inject
    internal lateinit var factory: UserDetailViewModelFactory
    //private val viewModel: UserDetailViewModel by lazy { factory.get() }

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

}