package com.danil.feature_films

import com.danil.util.Reducer

class FilmsScreenReducer : Reducer<FilmsScreenState, FilmsScreenAction> {
    override fun reduce(
        currentState: FilmsScreenState,
        action: FilmsScreenAction
    ): FilmsScreenState {
        return when (action) {
            is FilmsScreenAction.UpdateListFilms -> stateAfterUpdateListFilms(action, currentState)
            is FilmsScreenAction.UpdateScreenLoading -> currentState.copy(isLoading = action.isLoading)
            else -> currentState
        }
    }

    private fun stateAfterUpdateListFilms(
        action: FilmsScreenAction.UpdateListFilms,
        currentState: FilmsScreenState
    ): FilmsScreenState {
        return currentState.copy(
            listFilms = action.listFilms
        )
    }
}