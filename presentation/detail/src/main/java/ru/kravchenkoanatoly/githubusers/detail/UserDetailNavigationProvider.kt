package ru.kravchenkoanatoly.githubusers.detail

import ru.kravchenkoanatoly.githubusers.common.NavCommand

interface UserDetailNavigationProvider{
    fun goToSearchFragment(): NavCommand
}