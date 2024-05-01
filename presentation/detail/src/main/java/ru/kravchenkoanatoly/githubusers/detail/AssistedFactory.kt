package ru.kravchenkoanatoly.githubusers.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory


@AssistedFactory
internal interface UserDetailViewModelFactory {
    fun create(@Assisted("userName") userName: String): UserDetailViewModel
}

context(Fragment)
internal inline fun <reified VM : ViewModel> UserDetailViewModelFactory.get(
    userName: String,
): VM = viewModels<VM> {
    object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T = create(
            userName,

        ) as T
    }
}.value