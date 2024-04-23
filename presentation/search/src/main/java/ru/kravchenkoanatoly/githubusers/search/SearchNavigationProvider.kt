package ru.kravchenkoanatoly.githubusers.search

import ru.kravchenkoanatoly.githubusers.common.models.NavCommand

interface SearchNavigationProvider {
    fun goToUserDetail(): NavCommand
}