package com.danil.data

import com.danil.data.interactors_impl.GetFilmByUrlImpl
import com.danil.data.interactors_impl.GetFlowFilteredListFilmsImpl
import com.danil.data.interactors_impl.LoadFilmsIfNeededImpl
import com.danil.data.interactors_impl.RefreshFilmsImpl
import com.danil.data.interactors_impl.UpdateFilterQueryImpl
import com.danil.domain.interactors.GetFilmByUrl
import com.danil.domain.interactors.GetFlowFilteredListFilms
import com.danil.domain.interactors.LoadFilmsIfNeeded
import com.danil.domain.interactors.RefreshFilms
import com.danil.domain.interactors.UpdateFilterQuery
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
interface InteractorsModule {
    @Binds
    fun provideLoadFilmsIfNeeded(
        loadFilmsIfNeededImpl: LoadFilmsIfNeededImpl
    ): LoadFilmsIfNeeded

    @Binds
    fun provideGetFlowListFilms(
        getFlowListFilmsImpl: GetFlowFilteredListFilmsImpl
    ): GetFlowFilteredListFilms

    @Binds
    fun provideRefreshFilms(
        refreshFilmsImpl: RefreshFilmsImpl
    ): RefreshFilms

    @Binds
    fun provideUpdateFilterQuery(
        updateFilterQueryImpl: UpdateFilterQueryImpl
    ): UpdateFilterQuery

    @Binds
    fun provideGetFilmByUrl(
        getFilmByUrlImpl: GetFilmByUrlImpl
    ): GetFilmByUrl
}