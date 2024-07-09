package com.danil.feature_films

import com.danil.domain.model.Film
import com.danil.util.Action

interface FilmsScreenAction: Action {
    data object LoadFilms: FilmsScreenAction
    data class UpdateListFilms(val listFilms: List<Film>): FilmsScreenAction
    data class UpdateScreenLoading(val isLoading: Boolean): FilmsScreenAction
    data object RefreshListFilms: FilmsScreenAction
    data class UpdateFilterQuery(val query: String): FilmsScreenAction
}