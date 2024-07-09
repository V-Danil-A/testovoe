package com.danil.domain.interactors

import com.danil.domain.usecase.UseCase

interface LoadFilmsIfNeeded: UseCase<UseCase.None, UseCase.None> {
    override suspend fun run(params: UseCase.None): UseCase.None
}