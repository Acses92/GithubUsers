package ru.kravchenkoanatoly.githubusers

import androidx.core.os.bundleOf
import ru.kravchenkoanatoly.githubusers.common.models.NavCommand
import ru.kravchenkoanatoly.githubusers.detail.UserDetailFragment
import ru.kravchenkoanatoly.githubusers.detail.UserDetailNavigationProvider
import ru.kravchenkoanatoly.githubusers.search.SearchNavigationProvider
import javax.inject.Inject

class SearchNavigationProviderImpl @Inject constructor(): SearchNavigationProvider {
    override fun goToUserDetail(
        userName: String,
        userAvatar: String,
        id: Int
    ): NavCommand  = NavCommand(
        action = R.id.action_searchFragment_to_detailFragment, args = bundleOf(
            UserDetailFragment.USER_ID_DETAIL_FRAGMENT_KEY to id,
            UserDetailFragment.USER_AVATAR_DETAIL_FRAGMENT_KEY to userAvatar,
            UserDetailFragment.USERNAME_DETAIL_FRAGMENT_KEY to userName
        )

    )

}

class UserDetailNavigationProviderImpl @Inject constructor(): UserDetailNavigationProvider {
    override fun goToSearchFragment(): NavCommand {
        TODO("Not yet implemented")
    }

}