package com.danil.feature_character

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danil.util.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterScreenViewModel @Inject constructor(
    characterScreenMiddleware: CharacterScreenMiddleware
): ViewModel() {
    private val store = Store(
        initialState = CharacterScreenState(),
        reducer = CharacterScreenReducer(),
        middlewares = listOf(
            characterScreenMiddleware
        )
    )

    val viewState = store.state

    fun getFilmByUrl(filmUrl: String) {
        viewModelScope.launch {
            store.dispatch(CharacterScreenAction.GetFilmByUrl(filmUrl))
        }
    }

}