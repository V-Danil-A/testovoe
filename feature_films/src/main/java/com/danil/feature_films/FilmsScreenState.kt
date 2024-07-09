package com.danil.feature_films

import com.danil.domain.Film
import com.danil.util.State

data class FilmsScreenState(
    val listFilms: List<Film> = emptyList(),
    val isLoading: Boolean = false
): State
