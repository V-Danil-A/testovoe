package com.danil.data.interactors_impl

import com.danil.domain.interactors.LoadFilmsIfNeeded
import com.danil.domain.repositories.FilmsRepository
import com.danil.domain.usecase.UseCase
import kotlinx.coroutines.delay
import javax.inject.Inject

class LoadFilmsIfNeededImpl @Inject constructor(
    private val filmsRepository: FilmsRepository
): LoadFilmsIfNeeded {
    override suspend fun run(params: UseCase.None): UseCase.None {
        filmsRepository.loadFilmsIfNeeded()
        return UseCase.None()
    }
}