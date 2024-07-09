package com.danil.domain.interactors

import com.danil.domain.Film
import com.danil.domain.usecase.UseCase

interface GetFilmByUrl: UseCase<Film, String> {
    override suspend fun run(params: String): Film
}