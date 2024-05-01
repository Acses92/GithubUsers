package ru.kravchenkoanatoly.githubusers.detail

interface UserDetailAction {
    data class Error(val messages: String): UserDetailAction
}