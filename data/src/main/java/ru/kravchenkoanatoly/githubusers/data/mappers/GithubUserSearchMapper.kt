package ru.kravchenkoanatoly.githubusers.data.mappers

import ru.kravchenkoanatoly.githubusers.data.models.dto.response.GithubUserSearchDto
import ru.kravchenkoanatoly.githubusers.models.GithubUserSearchDomain

fun GithubUserSearchDto.toDomain(): GithubUserSearchDomain = GithubUserSearchDomain(
    avatarUrl,
    eventsUrl,
    followersUrl,
    followingUrl,
    gistsUrl,
    gravatarId,
    htmlUrl,
    id,
    login,
    nodeId,
    organizationsUrl,
    receivedEventsUrl,
    reposUrl,
    score,
    siteAdmin,
    starredUrl,
    subscriptionsUrl,
    type,
    url
)