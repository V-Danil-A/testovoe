package com.danil.data.interactors_impl

import com.danil.domain.interactors.RefreshFilms
import com.danil.domain.repositories.FilmsRepository
import com.danil.domain.usecase.UseCase
import javax.inject.Inject

class RefreshFilmsImpl @Inject constructor(
    private val filmsRepository: FilmsRepository
): RefreshFilms {
    override suspend fun run(params: UseCase.None): UseCase.None {
        filmsRepository.loadFilms()
        return UseCase.None()
    }
}