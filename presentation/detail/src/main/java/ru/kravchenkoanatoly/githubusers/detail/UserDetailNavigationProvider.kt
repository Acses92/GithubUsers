package ru.kravchenkoanatoly.githubusers.detail

import ru.kravchenkoanatoly.githubusers.common.models.NavCommand

interface UserDetailNavigationProvider{
    fun goToSearchFragment(): NavCommand
}