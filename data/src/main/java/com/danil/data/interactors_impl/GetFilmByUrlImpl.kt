package com.danil.data.interactors_impl

import com.danil.domain.Film
import com.danil.domain.interactors.GetFilmByUrl
import com.danil.domain.repositories.FilmsRepository
import javax.inject.Inject

class GetFilmByUrlImpl @Inject constructor(
    private val filmsRepository: FilmsRepository
): GetFilmByUrl {
    override suspend fun run(params: String): Film {
        return filmsRepository.getFilmByUrl(params)
    }
}