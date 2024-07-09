package com.danil.feature_character

import com.danil.util.State

data class CharacterScreenState(
    val characterUrl: String = "",
    val filmName: String = ""
): State
