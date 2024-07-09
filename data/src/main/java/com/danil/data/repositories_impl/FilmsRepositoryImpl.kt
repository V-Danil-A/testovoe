package com.danil.data.repositories_impl

import android.content.Context
import androidx.room.Room
import com.danil.data.data_base.FilmDatabase
import com.danil.data.data_base.FilmsDao
import com.danil.data.mappers.FilmResponseToListFilms
import com.danil.data.network.FilmsNetworkDataSource
import com.danil.domain.Film
import com.danil.domain.repositories.FilmsRepository
import dagger.Binds
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

class FilmsRepositoryImpl @Inject constructor(
    private val filmsNetworkDataSource: FilmsNetworkDataSource,
    @ApplicationContext context: Context,
) : FilmsRepository {
    val filmsDao = Room.databaseBuilder(
        context,
        FilmDatabase::class.java, "films"
    ).build().filmsDao()

    private val filterFlow = MutableStateFlow("")

    private val filteredListFilms: StateFlow<List<Film>> = combine(filmsDao.getAll(), filterFlow) { recor, filter ->
        filmsDao.getAllByQuery("%$filter%")
    }.stateIn(CoroutineScope(Dispatchers.IO), SharingStarted.Lazily, emptyList())


    override suspend fun loadFilmsIfNeeded() {
        if (isNeedLoadFilms()) {
            loadFilms()
        }
    }

    override suspend fun updateFilterQuery(query: String) {
        filterFlow.emit(query)
    }

    override suspend fun getFilmByUrl(filmUrl: String) = withContext(Dispatchers.IO) {
            return@withContext filmsDao.getFilmByUrl(filmUrl)
        }

    override suspend fun getFlowListFilmsFiltered(): Flow<List<Film>> = filteredListFilms

    private suspend fun saveListFilms(list: List<Film>) {
        withContext(Dispatchers.IO) {
            filmsDao.saveListFilms(list)
        }
    }

    private suspend fun isNeedLoadFilms(): Boolean = withContext(Dispatchers.IO) {
        filmsDao.isEmpty()
    }

    override suspend fun loadFilms() = withContext(Dispatchers.IO) {
        val filmsOrFailure = filmsNetworkDataSource.loadFilms()
        if (filmsOrFailure.isLeft) {
            val listFilms = FilmResponseToListFilms().invoke(filmsOrFailure.getLeft())
            saveListFilms(listFilms)
        } else {

        }
    }



}