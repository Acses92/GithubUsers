package ru.kravchenkoanatoly.githubusers.data.repositories

import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import ru.kravchenkoanatoly.githubusers.data.sources.remote.GithubApi
import ru.kravchenkoanatoly.githubusers.models.GithubUserSearchDomain
import ru.kravchenkoanatoly.githubusers.repositories.GithubSearchRepository
import javax.inject.Inject

class GithubSearchRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi,
    private val moshi: Moshi
): GithubSearchRepository {
    override fun searchUser(userRequest: String): Flow<GithubUserSearchDomain> {
        TODO("Not yet implemented")
    }
}