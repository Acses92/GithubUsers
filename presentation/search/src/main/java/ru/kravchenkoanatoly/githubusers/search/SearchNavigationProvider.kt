package ru.kravchenkoanatoly.githubusers.search

import ru.kravchenkoanatoly.githubusers.common.models.NavCommand

interface SearchNavigationProvider {
    fun goToUserDetail(
        userName: String,
        userAvatar: String,
        id: Int
    ): NavCommand
}