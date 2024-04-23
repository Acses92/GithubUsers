package ru.kravchenkoanatoly.githubusers.models

import java.io.Serializable

data class GithubUserSearchDomain(
    val id: Int,
    val avatarUrl: String,
    val followersUrl: String,
    val login: String,
    var followersNumber: Int,
): Serializable
