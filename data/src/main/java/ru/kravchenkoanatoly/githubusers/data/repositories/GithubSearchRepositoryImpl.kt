package ru.kravchenkoanatoly.githubusers.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import ru.kravchenkoanatoly.githubusers.data.mappers.toEntity
import ru.kravchenkoanatoly.githubusers.data.sources.database.AppDatabase
import ru.kravchenkoanatoly.githubusers.data.sources.remote.GithubApi
import ru.kravchenkoanatoly.githubusers.repositories.GithubSearchRepository
import timber.log.Timber
import javax.inject.Inject

class GithubSearchRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi,
    private val appDatabase: AppDatabase
): GithubSearchRepository {
    override fun searchUser(userRequest: String, pageSize: Int, page: Int): Flow<Unit> = flow<Unit> {
        val items = githubApi.searchUsers(userRequest, pageSize,page).items
            if(items.isNotEmpty()){
                items.onEach { appDatabase.githubSearchUserDao().deleteAll() }
                    .map { dto ->
                        dto?.toEntity() }
                    .forEach {
                        if (it != null) {
                            appDatabase.githubSearchUserDao().insert(it)
                        }
                    }
            } else {
                appDatabase.githubSearchUserDao().deleteAll()
            }

    }.catch {Timber.tag(GITHUB_SEARCH_REPOSITORY_TAG).d(it)  }

    override fun getMaxUsersFromRequest(userRequest: String): Flow<Int> = flow<Int> {
        emit(githubApi.searchUsers(userRequest, 1,1).totalCount)
    }.catch { Timber.tag(GITHUB_SEARCH_REPOSITORY_TAG).d(it) }


    companion object {
        const val GITHUB_SEARCH_REPOSITORY_TAG = "GITHUB_SEARCH_REPOSITORY_TAG"
    }
}