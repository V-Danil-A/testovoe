package com.danil.data.data_base

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.danil.domain.model.Film
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveListFilms(listFilms: List<Film>)

    @Query("SELECT * FROM films ORDER BY episodeId")
    fun getAll(): Flow<List<Film>>

    @Query("SELECT * FROM films WHERE title LIKE :query ORDER BY episodeId")
    fun getAllByQuery(query: String): List<Film>

    @Query("SELECT (SELECT COUNT(*) FROM films) == 0")
    fun isEmpty(): Boolean

    @Query("SELECT * FROM films WHERE filmUrl = :filmUrl")
    fun getFilmByUrl(filmUrl: String): Film
}