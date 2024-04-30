package ru.kravchenkoanatoly.githubusers.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory


@AssistedFactory
internal interface UserDetailViewModelFactory{
    fun create(@Assisted("userName")userName: String,
               @Assisted("id") id: Int,
               @Assisted("userAvatar") userAvatar: String): UserDetailViewModel
}

context(Fragment)
internal inline fun <reified VM: ViewModel> UserDetailViewModelFactory.get(
    userName: String,
    userAvatar: String,
    id: Int
): VM = viewModels<VM> {
    object: ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T = create(
            userName,
            id,
            userAvatar
        ) as T
    }
}.value