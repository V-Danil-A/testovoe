package com.danil.techtest

import com.danil.navigation.CharacterNavigation
import com.danil.navigation.FilmsNavigation
import com.danil.techtest.navigation_impl.CharacterNavigationImpl
import com.danil.techtest.navigation_impl.FilmsNavigationImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface ActivityModule {
    @Binds
    fun provideFilmsNavigationImpl(filmsNavigationImpl: FilmsNavigationImpl): FilmsNavigation

    @Binds
    fun provideCharacterNavigation(characterNavigationImpl: CharacterNavigationImpl): CharacterNavigation
}
