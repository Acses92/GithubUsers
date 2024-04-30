package ru.kravchenkoanatoly.githubusers.detail

import androidx.lifecycle.ViewModel
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

class UserDetailViewModel @AssistedInject constructor(
    @Assisted("userName") private val userName: String,
    @Assisted("id") private val id: Int,
    @Assisted("userAvatar") private val userAvatar: String,
) : ViewModel() {
}