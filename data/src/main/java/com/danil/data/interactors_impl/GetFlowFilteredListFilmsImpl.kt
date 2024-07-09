package com.danil.data.interactors_impl

import com.danil.domain.Film
import com.danil.domain.interactors.GetFlowFilteredListFilms
import com.danil.domain.repositories.FilmsRepository
import com.danil.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFlowFilteredListFilmsImpl @Inject constructor(
    private val filmsRepository: FilmsRepository
): GetFlowFilteredListFilms {
    override suspend fun run(params: UseCase.None): Flow<List<Film>> {
        return filmsRepository.getFlowListFilmsFiltered()
    }
}