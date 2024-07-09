package com.danil.network

import com.danil.domain.exception.Failure
import retrofit2.HttpException
import java.net.SocketException
import java.net.UnknownHostException

object FetchError {

    fun detectError(exception: Exception): Failure {
        return when (exception) {
            is HttpException -> detectHttpError(exception)
            is UnknownHostException -> Failure.NetworkConnection
            is java.io.InterruptedIOException -> {
                if (exception.cause is SocketException) Failure.NetworkConnection else Failure.ExternalError
            }
            else -> Failure.ExternalError
        }
    }

    private fun detectHttpError(error: HttpException): Failure {
        return when (error.code()) {
            500 -> {
                Failure.ServerError
            }
            400 -> Failure.BadRequest
            else -> Failure.ExternalError
        }
    }
}