package ru.kravchenkoanatoly.githubusers.useCases

import ru.kravchenkoanatoly.githubusers.repositories.GithubSearchRepository
import javax.inject.Inject

class GithubSearchUseCase @Inject constructor(
    private val repository: GithubSearchRepository
) {
    fun searchUser(username: String) = repository.searchUser(username)
}