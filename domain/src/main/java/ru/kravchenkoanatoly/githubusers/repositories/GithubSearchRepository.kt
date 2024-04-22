package ru.kravchenkoanatoly.githubusers.repositories

import kotlinx.coroutines.flow.Flow
import ru.kravchenkoanatoly.githubusers.models.GithubUserSearchDomain

interface GithubSearchRepository {
    fun searchUser(userRequest: String): Flow<GithubUserSearchDomain>
}