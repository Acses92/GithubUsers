package ru.kravchenkoanatoly.githubusers.data.sources.remote

import retrofit2.http.GET
import retrofit2.http.Path
import ru.kravchenkoanatoly.githubusers.data.models.dto.response.FollowersResponseDto
import ru.kravchenkoanatoly.githubusers.data.models.dto.response.UsersSearchResponseDto

interface GithubApi {
    @GET("/search/users?q={userRequest}")
    suspend fun searchUsers(
        @Path("userRequest") user: String
    ): UsersSearchResponseDto

    @GET("/users/{user}/followers")
    suspend fun getUserFollower(
        @Path("user") user: String
    ): FollowersResponseDto


    @GET("/users/{user}")
    suspend fun getUserInfo(
        @Path("user") user: String
    ): FollowersResponseDto
}