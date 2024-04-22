package ru.kravchenkoanatoly.githubusers.search

import ru.kravchenkoanatoly.githubusers.common.NavCommand

interface SearchNavigationProvider {
    fun goToUserDetail(): NavCommand
}