package com.danil.feature_films

import com.danil.domain.interactors.LoadFilmsIfNeeded
import com.danil.domain.interactors.RefreshFilms
import com.danil.domain.interactors.UpdateFilterQuery
import com.danil.domain.usecase.UseCase
import com.danil.util.Middleware
import com.danil.util.Store
import javax.inject.Inject

class FilmsScreenMiddleware @Inject constructor(
    private val loadFilmsIfNeeded: LoadFilmsIfNeeded,
    private val refreshFilms: RefreshFilms,
    private val updateFilterQuery: UpdateFilterQuery
): Middleware<FilmsScreenState, FilmsScreenAction> {
    override suspend fun process(
        action: FilmsScreenAction,
        currentState: FilmsScreenState,
        store: Store<FilmsScreenState, FilmsScreenAction>
    ) {
        when(action) {
            is FilmsScreenAction.LoadFilms -> loadFilmsIfNeeded(store)
            is FilmsScreenAction.RefreshListFilms -> refreshFilms(store)
            is FilmsScreenAction.UpdateFilterQuery -> updateFilterQuery.run(action.query)
        }
    }

    private suspend fun loadFilmsIfNeeded(store: Store<FilmsScreenState, FilmsScreenAction>) {
        store.dispatch(FilmsScreenAction.UpdateScreenLoading(true))
        loadFilmsIfNeeded.run(UseCase.None())
        store.dispatch(FilmsScreenAction.UpdateScreenLoading(false))
    }

    private suspend fun refreshFilms(store: Store<FilmsScreenState, FilmsScreenAction>) {
        store.dispatch(FilmsScreenAction.UpdateScreenLoading(true))
        refreshFilms.run(UseCase.None())
        store.dispatch(FilmsScreenAction.UpdateScreenLoading(false))
    }
}