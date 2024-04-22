package ru.kravchenkoanatoly.githubusers.data.models.dto.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UsersSearchResponseDto(
    @Json(name = "incomplete_results")
    val incompleteResults: Boolean,
    @Json(name = "items")
    val items: List<GithubUserSearchDto?>,
    @Json(name = "total_count")
    val totalCount: Int
)