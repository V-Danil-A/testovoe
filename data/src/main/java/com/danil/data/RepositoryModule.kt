package com.danil.data

import android.content.Context
import androidx.room.Room
import com.danil.data.data_base.FilmDatabase
import com.danil.data.data_base.FilmsDao
import com.danil.data.network.FilmsNetworkDataSource
import com.danil.data.network.FilmsNetworkDataSourceImpl
import com.danil.data.repositories_impl.FilmsRepositoryImpl
import com.danil.domain.repositories.FilmsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface RepositoryModule {
    @Binds
    @Singleton
    fun provideFilmsNetworkDataSource(
        filmsNetworkDataSourceImpl: FilmsNetworkDataSourceImpl
    ): FilmsNetworkDataSource

    @Binds
    @Singleton
    fun provideFilmsRepository(
        filmsRepositoryImpl: FilmsRepositoryImpl
    ): FilmsRepository

//    @Binds
//    @Singleton
//    fun provideFilmsRoom(
//        @ApplicationContext context: Context
//    ): FilmsDao {
//        val db = Room.databaseBuilder(
//            context,
//            FilmDatabase::class.java, "films"
//        ).build()
//        return db.filmsDao()
//    }
}