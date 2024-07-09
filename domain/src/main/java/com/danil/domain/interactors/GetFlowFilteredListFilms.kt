package com.danil.domain.interactors

import com.danil.domain.Film
import com.danil.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow

interface GetFlowFilteredListFilms: UseCase<Flow<List<Film>>, UseCase.None> {
    override suspend fun run(params: UseCase.None): Flow<List<Film>>
}