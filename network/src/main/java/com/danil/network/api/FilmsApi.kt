package com.danil.network.api

import com.danil.network.FilmResponseDTO
import retrofit2.http.GET

interface FilmsApi {
    @GET("films")
    suspend fun loadFilms(): FilmResponseDTO
}