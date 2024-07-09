package com.danil.data.mappers

import com.danil.domain.model.Film
import com.danil.network.FilmResponseDTO

class FilmResponseToListFilms: Mapper<FilmResponseDTO, List<Film>> {
    override fun invoke(p1: FilmResponseDTO): List<Film> {
        return p1.listFilms?.map {
            Film(
                title = it.title ?: "",
                filmUrl = it.url ?: "",
                episodeId = it.episodeId ?: 0,
                producer = it.producer ?: "",
                director = it.director ?: "",
                releaseDate = it.releaseDate ?: ""
            )
        } ?: emptyList()
    }
}