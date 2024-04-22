package ru.kravchenkoanatoly.githubusers.data.mappers

import ru.kravchenkoanatoly.githubusers.data.models.dto.response.GithubUserInfoDto
import ru.kravchenkoanatoly.githubusers.models.GithubUserInfoDomain

fun GithubUserInfoDto.toDomain(): GithubUserInfoDomain =
        GithubUserInfoDomain(
            avatarUrl,
            bio,
            blog,
            company,
            createdAt,
            documentationUrl,
            email,
            eventsUrl,
            followers,
            followersUrl,
            following,
            followingUrl,
            gistsUrl,
            gravatarId,
            hireable,
            htmlUrl,
            id,
            location,
            login,
            message,
            name,
            nodeId,
            organizationsUrl,
            publicGists,
            publicRepos,
            receivedEventsUrl,
            reposUrl,
            siteAdmin,
            starredUrl,
            subscriptionsUrl,
            twitterUsername,
            type,
            updatedAt,
            url
        )