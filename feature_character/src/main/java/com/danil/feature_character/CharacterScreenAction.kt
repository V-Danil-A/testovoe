package com.danil.feature_character

import com.danil.domain.Film
import com.danil.util.Action

interface CharacterScreenAction: Action {
    data class GetFilmByUrl(val filmUrl: String): CharacterScreenAction
    data class UpdateFilm(val film: Film): CharacterScreenAction
    data class LoadCharactersIfNeeded(val filmUrl: String): CharacterScreenAction
}