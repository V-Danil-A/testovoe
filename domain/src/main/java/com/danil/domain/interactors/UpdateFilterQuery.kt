package com.danil.domain.interactors

import com.danil.domain.usecase.UseCase

interface UpdateFilterQuery: UseCase<UseCase.None, String> {
    override suspend fun run(params: String): UseCase.None
}