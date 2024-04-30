package ru.kravchenkoanatoly.githubusers.common.models


data class ReloadableData<out T>(val data: T?, val status: Status)

sealed class Status {
    object Idle: Status()
    object Loading: Status()
    object Failure: Status()
}