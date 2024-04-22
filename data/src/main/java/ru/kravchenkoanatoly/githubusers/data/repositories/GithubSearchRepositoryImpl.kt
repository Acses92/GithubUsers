package ru.kravchenkoanatoly.githubusers.data.repositories

import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import ru.kravchenkoanatoly.githubusers.data.mappers.toDomain
import ru.kravchenkoanatoly.githubusers.data.sources.remote.GithubApi
import ru.kravchenkoanatoly.githubusers.models.GithubUserSearchDomain
import ru.kravchenkoanatoly.githubusers.repositories.GithubSearchRepository
import timber.log.Timber
import javax.inject.Inject

class GithubSearchRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi,
): GithubSearchRepository {
    override fun searchUser(userRequest: String): Flow<List<GithubUserSearchDomain?>> = flow {
        emit(githubApi.searchUsers(userRequest))
    }
        .map { dto -> dto.items.map { it?.toDomain() } }
        .catch { Timber.tag(GITHUB_SEARCH_REPOSITORY_TAG).d(it)  }

    companion object {
        const val GITHUB_SEARCH_REPOSITORY_TAG = "GITHUB_SEARCH_REPOSITORY_TAG"
    }
}