package ru.kravchenkoanatoly.githubusers

import ru.kravchenkoanatoly.githubusers.common.NavCommand
import ru.kravchenkoanatoly.githubusers.detail.UserDetailNavigationProvider
import ru.kravchenkoanatoly.githubusers.search.SearchNavigationProvider
import javax.inject.Inject

class SearchNavigationProviderImpl @Inject constructor(): SearchNavigationProvider {
    override fun goToUserDetail(): NavCommand {
        TODO("Not yet implemented")
    }

}

class UserDetailNavigationProviderImpl @Inject constructor(): UserDetailNavigationProvider {
    override fun goToSearchFragment(): NavCommand {
        TODO("Not yet implemented")
    }

}