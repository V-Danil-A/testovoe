package com.danil.data.interactors_impl

import com.danil.domain.interactors.UpdateFilterQuery
import com.danil.domain.repositories.FilmsRepository
import com.danil.domain.usecase.UseCase
import javax.inject.Inject

class UpdateFilterQueryImpl @Inject constructor(
    private val filmsRepository: FilmsRepository
): UpdateFilterQuery {
    override suspend fun run(params: String): UseCase.None {
        filmsRepository.updateFilterQuery(params)
        return UseCase.None()
    }
}