package com.danil.feature_character

import com.danil.domain.interactors.GetFilmByUrl
import com.danil.util.Middleware
import com.danil.util.Store
import javax.inject.Inject

class CharacterScreenMiddleware @Inject constructor(
    private val getFilmByUrl: GetFilmByUrl
) : Middleware<CharacterScreenState, CharacterScreenAction> {
    override suspend fun process(
        action: CharacterScreenAction,
        currentState: CharacterScreenState,
        store: Store<CharacterScreenState, CharacterScreenAction>
    ) {
        when (action) {
            is CharacterScreenAction.GetFilmByUrl ->getFilm(action, store)
        }
    }

    private suspend fun getFilm(
        action: CharacterScreenAction.GetFilmByUrl,
        store: Store<CharacterScreenState, CharacterScreenAction>
    ) {
        val film = getFilmByUrl.run(action.filmUrl)
        store.dispatch(CharacterScreenAction.UpdateFilm(film))
    }
}