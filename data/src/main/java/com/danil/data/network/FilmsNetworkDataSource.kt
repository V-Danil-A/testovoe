package com.danil.data.network

import com.danil.domain.exception.Failure
import com.danil.domain.util.Either
import com.danil.network.FilmResponseDTO

interface FilmsNetworkDataSource {
    suspend fun loadFilms(): Either<FilmResponseDTO, Failure>
}