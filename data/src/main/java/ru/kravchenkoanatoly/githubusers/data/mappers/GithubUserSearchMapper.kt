package ru.kravchenkoanatoly.githubusers.data.mappers

import ru.kravchenkoanatoly.githubusers.data.models.dto.response.GithubUserSearchDto
import ru.kravchenkoanatoly.githubusers.data.models.entity.GithubSearchUserEntity
import ru.kravchenkoanatoly.githubusers.models.GithubUserSearchDomain

fun GithubUserSearchDto.toDomain(): GithubUserSearchDomain = GithubUserSearchDomain(
    avatarUrl = avatarUrl,
    followersUrl = followersUrl,
    id = id,
    login = login,
    followersNumber = 0
)

fun GithubUserSearchDto.toEntity(): GithubSearchUserEntity = GithubSearchUserEntity(
    avatarUrl = avatarUrl,
    followersUrl = followersUrl,
    id = id,
    login = login,
    followersNumber = 0
)

fun GithubSearchUserEntity.toDomain(): GithubUserSearchDomain = GithubUserSearchDomain(
    avatarUrl = avatarUrl,
    followersUrl = followersUrl,
    id = id,
    login = login,
    followersNumber = followersNumber
)