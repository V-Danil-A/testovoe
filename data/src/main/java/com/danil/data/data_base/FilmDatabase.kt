package com.danil.data.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.danil.domain.model.Film

@Database( entities = [Film::class], version = 1)
abstract class FilmDatabase: RoomDatabase() {
    abstract fun filmsDao(): FilmsDao
}