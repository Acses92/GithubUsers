package ru.kravchenkoanatoly.githubusers.common

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseFragment(@LayoutRes private val layoutRes: Int): Fragment(layoutRes)  {
    protected fun navigate(navCommand: NavCommand){
        findNavController().navigate(navCommand.action, navCommand.args, navCommand.navOptions)
    }

    protected fun exit() {
        findNavController().popBackStack()
    }

    protected fun <T> Flow<T>.repeatOnStarted(){
        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                collect()
            }
        }
    }

    protected fun <T> Flow<T>.repeatOnResumed(){
        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                collect()
            }
        }
    }

    protected fun <T> Flow<T>.repeatOnCreated(){
        viewLifecycleOwner.lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.CREATED) {
                collect()
            }
        }
    }
}