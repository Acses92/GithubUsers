package ru.kravchenkoanatoly.githubusers.search

interface GithubUserAction {
    data class OnClickedUser(val id: Int, val userName:String, val userAvatar: String): GithubUserAction
    data class Error(val message: String): GithubUserAction
}