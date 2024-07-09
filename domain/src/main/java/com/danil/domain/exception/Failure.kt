package com.danil.domain.exception

sealed interface Failure {
    data object NetworkConnection: Failure
    data object ServerError: Failure
    data object ExternalError: Failure
    data object BadRequest: Failure
}