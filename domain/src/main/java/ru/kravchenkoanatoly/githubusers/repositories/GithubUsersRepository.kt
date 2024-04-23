package ru.kravchenkoanatoly.githubusers.repositories

import kotlinx.coroutines.flow.Flow
import ru.kravchenkoanatoly.githubusers.models.GithubUserInfoDomain

interface GithubUsersRepository {
    fun getUserInfo(user: String): Flow<GithubUserInfoDomain>

    fun getUserFollowers(user: String): Flow<Int>
}