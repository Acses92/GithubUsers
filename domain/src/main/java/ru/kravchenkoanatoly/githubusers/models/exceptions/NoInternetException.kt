package ru.kravchenkoanatoly.githubusers.models.exceptions

open class NoInternetException(
    originalThrowable: Throwable? = null
) : NetworkException(originalThrowable) {

    override val message: String?
        get() = "NoInternetException [${originalThrowable?.message}]"
}