package com.danil.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class Character(
    @PrimaryKey
    val url: String,
    val name: String,
    val gender: String,
    val birthYear: String
)