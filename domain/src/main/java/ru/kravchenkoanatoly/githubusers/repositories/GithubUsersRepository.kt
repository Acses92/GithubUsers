package ru.kravchenkoanatoly.githubusers.repositories

import kotlinx.coroutines.flow.Flow
import ru.kravchenkoanatoly.githubusers.models.GithubUserInfoDomain
import ru.kravchenkoanatoly.githubusers.models.UserRepositoriesDomain

interface GithubUsersRepository {
    fun getUserInfo(user: String): Flow<GithubUserInfoDomain>

    fun getUserFollowers(user: String, pageSize: Int): Flow<Int>

    fun getUserRepositories(user: String): Flow<List<UserRepositoriesDomain>>
}