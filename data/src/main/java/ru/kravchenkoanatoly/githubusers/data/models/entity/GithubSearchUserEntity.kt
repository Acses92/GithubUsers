package ru.kravchenkoanatoly.githubusers.data.models.entity

import androidx.room.Entity

@Entity(
    tableName = "github_search_user",
    primaryKeys = ["id", "login"]
)
data class GithubSearchUserEntity(
    val id: Int,
    val avatarUrl: String,
    val followersUrl: String,
    val login: String,
    var followersNumber: Int
)