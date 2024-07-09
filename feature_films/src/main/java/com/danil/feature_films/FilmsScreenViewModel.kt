package com.danil.feature_films

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danil.domain.interactors.GetFlowFilteredListFilms
import com.danil.domain.usecase.UseCase
import com.danil.util.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmsScreenViewModel @Inject constructor(
    filmsScreenMiddleware: FilmsScreenMiddleware,
    private val getFlowFilteredListFilms: GetFlowFilteredListFilms
): ViewModel() {

    private val store = Store(
        initialState = FilmsScreenState(),
        reducer = FilmsScreenReducer(),
        middlewares = listOf(
            filmsScreenMiddleware
        )
    )

    val viewState = store.state

    fun screenReady() {
        viewModelScope.launch {
            store.dispatch(FilmsScreenAction.LoadFilms)
            collectListFilms()
        }
    }

    fun refreshFilms() {
        viewModelScope.launch {
            store.dispatch(FilmsScreenAction.RefreshListFilms)
        }
    }

    fun searchFilmsByQuery(query: String) {
        viewModelScope.launch {
            store.dispatch(FilmsScreenAction.UpdateFilterQuery(query))
        }
    }

    private suspend fun collectListFilms() {
        getFlowFilteredListFilms.run(UseCase.None()).collect {
            store.dispatch(FilmsScreenAction.UpdateListFilms(it))
        }
    }
}