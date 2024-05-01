package ru.kravchenkoanatoly.githubusers.repositories

import kotlinx.coroutines.flow.Flow

interface GithubSearchRepository {
    fun searchUser(userRequest: String, pageSize: Int, page: Int): Flow<Unit>

    fun getMaxUsersFromRequest(userRequest: String): Flow<Int>
}