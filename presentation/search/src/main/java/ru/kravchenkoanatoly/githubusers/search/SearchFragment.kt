package ru.kravchenkoanatoly.githubusers.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.kravchenkoanatoly.githubusers.common.BaseFragment
import ru.kravchenkoanatoly.githubusers.search.databinding.SearchFragmentBinding

@AndroidEntryPoint
class SearchFragment: BaseFragment(R.layout.search_fragment) {
    private var _binding: SearchFragmentBinding? = null
    private val binding get()= _binding!!
    private val viewModel by viewModels<SearchViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SearchFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}