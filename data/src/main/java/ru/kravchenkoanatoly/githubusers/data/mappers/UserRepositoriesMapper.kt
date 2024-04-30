package ru.kravchenkoanatoly.githubusers.data.mappers

import ru.kravchenkoanatoly.githubusers.data.models.dto.response.UserRepositoriesDtoItem
import ru.kravchenkoanatoly.githubusers.models.UserRepositoriesDomain

fun UserRepositoriesDtoItem.toDomain(): UserRepositoriesDomain = UserRepositoriesDomain(
    id = id,
    name = name,
    description = description,
    pushedAt = pushedAt,
    defaultBranch = defaultBranch,
    forksCount = forksCount,
    stargazersCount = stargazersCount,
    language = language
)
