package com.danil.feature_character

import com.danil.util.Reducer

class CharacterScreenReducer : Reducer<CharacterScreenState, CharacterScreenAction> {
    override fun reduce(
        currentState: CharacterScreenState,
        action: CharacterScreenAction
    ): CharacterScreenState {
        return when (action) {
            is CharacterScreenAction.UpdateFilm -> stateAfterUpdateFilm(action, currentState)
            else -> currentState
        }
    }

    private fun stateAfterUpdateFilm(
        action: CharacterScreenAction.UpdateFilm,
        currentState: CharacterScreenState
    ): CharacterScreenState {
        return currentState.copy(
            filmName = action.film.title
        )
    }
}