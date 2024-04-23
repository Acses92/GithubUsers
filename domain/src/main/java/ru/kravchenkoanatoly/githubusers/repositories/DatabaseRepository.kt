package ru.kravchenkoanatoly.githubusers.repositories

import kotlinx.coroutines.flow.Flow
import ru.kravchenkoanatoly.githubusers.models.GithubUserSearchDomain

interface DatabaseRepository {
    fun subscribeGithubUserSearch(): Flow<List<GithubUserSearchDomain>>
}