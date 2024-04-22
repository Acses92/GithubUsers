package ru.kravchenkoanatoly.githubusers.data.repositories

import com.squareup.moshi.Moshi
import kotlinx.coroutines.flow.Flow
import ru.kravchenkoanatoly.githubusers.data.sources.remote.GithubApi
import ru.kravchenkoanatoly.githubusers.models.GithubUserInfoDomain
import ru.kravchenkoanatoly.githubusers.models.GithubUserSearchDomain
import ru.kravchenkoanatoly.githubusers.repositories.GithubUsersRepository
import javax.inject.Inject

class GithubUsersRepositoryImpl @Inject constructor(
    private val githubApi: GithubApi,
    private val moshi: Moshi
): GithubUsersRepository {
    override fun getUserInfo(user: String): Flow<GithubUserInfoDomain> {
        TODO("Not yet implemented")
    }

    override fun getUserFollowers(user: String): Flow<GithubUserSearchDomain> {
        TODO("Not yet implemented")
    }

}