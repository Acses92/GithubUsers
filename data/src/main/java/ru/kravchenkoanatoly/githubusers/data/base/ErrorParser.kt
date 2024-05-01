package ru.kravchenkoanatoly.githubusers.data.base

import retrofit2.HttpException
import ru.kravchenkoanatoly.githubusers.models.exceptions.HttpNetException
import ru.kravchenkoanatoly.githubusers.models.exceptions.NetworkException
import ru.kravchenkoanatoly.githubusers.models.exceptions.NoInternetException
import java.io.IOException
import java.net.UnknownHostException
import javax.inject.Inject

class ErrorParser @Inject constructor() {
    operator fun invoke(th: Throwable) {
        throw when (th) {
            is HttpException -> HttpNetException(th.code(), th.message(), th)
            is UnknownHostException -> NoInternetException(th)
            is NetworkException -> th
            else -> IOException(th)
        }
    }
}