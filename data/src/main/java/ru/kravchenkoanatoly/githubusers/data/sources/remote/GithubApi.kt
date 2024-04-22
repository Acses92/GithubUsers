package ru.kravchenkoanatoly.githubusers.data.sources.remote

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ru.kravchenkoanatoly.githubusers.data.models.dto.response.FollowersResponseDto
import ru.kravchenkoanatoly.githubusers.data.models.dto.response.GithubUserInfoDto
import ru.kravchenkoanatoly.githubusers.data.models.dto.response.GithubUserSearchDto
import ru.kravchenkoanatoly.githubusers.data.models.dto.response.UsersSearchResponseDto

interface GithubApi {
    @GET("/search/users")
    suspend fun searchUsers(
        @Query("q") user: String
    ): UsersSearchResponseDto

    @GET("/users/{user}/followers")
    suspend fun getUserFollower(
        @Path("user") user: String
    ): List<GithubUserSearchDto>


    @GET("/users/{user}")
    suspend fun getUserInfo(
        @Path("user") user: String
    ): GithubUserInfoDto
}