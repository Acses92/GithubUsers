package ru.kravchenkoanatoly.githubusers.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import ru.kravchenkoanatoly.githubusers.data.mappers.toDomain
import ru.kravchenkoanatoly.githubusers.data.sources.database.AppDatabase
import ru.kravchenkoanatoly.githubusers.data.sources.remote.GithubApi
import ru.kravchenkoanatoly.githubusers.models.GithubUserInfoDomain
import ru.kravchenkoanatoly.githubusers.models.UserRepositoriesDomain
import ru.kravchenkoanatoly.githubusers.repositories.GithubUsersRepository
import timber.log.Timber
import javax.inject.Inject

class GithubUsersRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi,
    private val appDatabase: AppDatabase
): GithubUsersRepository {
    override fun getUserInfo(user: String): Flow<GithubUserInfoDomain> = flow {
        emit(githubApi.getUserInfo(user))
    }
        .map { dto -> dto.toDomain() }
        .catch { Timber.tag(GITHUB_USER_REPOSITORY_TAG).d(it) }

    override fun getUserFollowers(user: String, pageSize: Int): Flow<Int> = flow {
        emit(githubApi.getUserFollower(user, pageSize).size)
    }
        .onEach {
            appDatabase.githubSearchUserDao().updateFollower(userName = user, followers = it, followersLoad = true )
        }
        .catch {  }

    override fun getUserRepositories(user: String): Flow<List<UserRepositoriesDomain>> = flow {
        emit(githubApi.getUserRepositories(user))
    }
        .map { dto -> dto.map { it.toDomain() } }
        .catch {  }


    companion object {
        const val GITHUB_USER_REPOSITORY_TAG = "GITHUB_USER_REPOSITORY_TAG"
    }

}