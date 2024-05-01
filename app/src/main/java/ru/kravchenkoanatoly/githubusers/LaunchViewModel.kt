package ru.kravchenkoanatoly.githubusers

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.kravchenkoanatoly.githubusers.useCases.GithubSearchUseCase
import ru.kravchenkoanatoly.githubusers.useCases.GithubUserUseCase
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val githubSearchUseCase: GithubSearchUseCase,
    private val githubUserUseCase: GithubUserUseCase
): ViewModel() {

}