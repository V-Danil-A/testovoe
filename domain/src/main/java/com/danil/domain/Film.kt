package com.danil.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class Film(
    @PrimaryKey
    val filmUrl: String,
    val episodeId: Int,
    val title: String,
    val releaseDate: String,
    val director: String,
    val producer: String
)