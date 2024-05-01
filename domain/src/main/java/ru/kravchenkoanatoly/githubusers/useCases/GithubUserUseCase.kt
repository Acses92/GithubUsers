package ru.kravchenkoanatoly.githubusers.useCases

import ru.kravchenkoanatoly.githubusers.repositories.GithubUsersRepository
import javax.inject.Inject

class GithubUserUseCase @Inject constructor(
    private val repository: GithubUsersRepository
) {
    fun getUserByUsername(username: String) = repository.getUserInfo(username)

    fun getUserFollowers(username: String, pageSize: Int) =
            repository.getUserFollowers(username, pageSize)

    fun getUserRepositories(username: String, pageSize: Int) =
            repository.getUserRepositories(username, pageSize)
}