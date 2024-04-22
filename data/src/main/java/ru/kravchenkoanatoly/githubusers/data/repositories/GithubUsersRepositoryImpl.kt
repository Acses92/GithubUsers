package ru.kravchenkoanatoly.githubusers.data.repositories

import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import ru.kravchenkoanatoly.githubusers.data.mappers.toDomain
import ru.kravchenkoanatoly.githubusers.data.models.dto.response.FollowersResponseDto
import ru.kravchenkoanatoly.githubusers.data.sources.remote.GithubApi
import ru.kravchenkoanatoly.githubusers.models.GithubUserInfoDomain
import ru.kravchenkoanatoly.githubusers.models.GithubUserSearchDomain
import ru.kravchenkoanatoly.githubusers.repositories.GithubUsersRepository
import timber.log.Timber
import javax.inject.Inject

class GithubUsersRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi,
    private val moshi: Moshi
): GithubUsersRepository {
    override fun getUserInfo(user: String): Flow<GithubUserInfoDomain> = flow {
        emit(githubApi.getUserInfo(user))
    }
        .map { dto -> dto.toDomain() }
        .catch { Timber.tag(GITHUB_USER_REPOSITORY_TAG).d(it) }

    /**
     * необходим кастомный адаптре для корректной работы с получаемым списком
     */
    override fun getUserFollowers(user: String): Flow<Int> = flow {
        emit(githubApi.getUserFollower(user))
    }
        .map {it.size}
        .catch { Timber.tag(GITHUB_USER_REPOSITORY_TAG).d("error = $it") }

    companion object {
        const val GITHUB_USER_REPOSITORY_TAG = "GITHUB_USER_REPOSITORY_TAG"
    }

}