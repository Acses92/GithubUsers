package ru.kravchenkoanatoly.githubusers.useCases

import ru.kravchenkoanatoly.githubusers.repositories.GithubSearchRepository
import javax.inject.Inject

class GithubSearchUseCase @Inject constructor(
    private val repository: GithubSearchRepository
) {
    fun searchUser(username: String, pageSize: Int, page: Int) = repository.searchUser(username, pageSize, page)

    fun getMaxUsersFromRequest(username: String) = repository.getMaxUsersFromRequest(username)
}