package com.danil.domain.usecase

interface UseCase<out Type, in Params> where Type : Any {
    suspend fun run(params: Params): Type
    class None
}