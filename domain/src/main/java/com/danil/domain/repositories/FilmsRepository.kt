package com.danil.domain.repositories

import com.danil.domain.model.Film
import kotlinx.coroutines.flow.Flow

interface FilmsRepository {
    suspend fun loadFilmsIfNeeded()
    suspend fun getFlowListFilmsFiltered(): Flow<List<Film>>
    suspend fun loadFilms()
    suspend fun updateFilterQuery(query: String)
    suspend fun getFilmByUrl(filmUrl: String): Film
}