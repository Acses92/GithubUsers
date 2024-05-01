package ru.kravchenkoanatoly.githubusers.models

import java.io.Serializable

data class UserRepositoriesDomain(
    val id: Int,
    val name: String?,
    val description: String?,
    val pushedAt: String?,
    val defaultBranch: String?,
    val forksCount: Int?,
    val stargazersCount: Int?,
    val language: String?
) : Serializable