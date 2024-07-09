package com.danil.network

import com.google.gson.annotations.SerializedName

data class FilmResponseDTO(
    @SerializedName("results")
    val listFilms: ArrayList<FilmDTO>?
) {
    data class FilmDTO(
        @SerializedName("title")
        val title: String?,
        @SerializedName("episode_id")
        val episodeId: Int?,
        @SerializedName("opening_crawl")
        val openingCrawl: String?,
        @SerializedName("director")
        val director: String?,
        @SerializedName("producer")
        val producer: String?,
        @SerializedName("release_date")
        val releaseDate: String?,
        @SerializedName("characters")
        val characters: ArrayList<String>?,
        @SerializedName("planets")
        val planets: ArrayList<String>?,
        @SerializedName("starships")
        val starships: ArrayList<String>?,
        @SerializedName("vehicles")
        val vehicles: ArrayList<String>?,
        @SerializedName("species")
        val species: ArrayList<String>?,
        @SerializedName("created")
        val created: String?,
        @SerializedName("edited")
        val edited: String?,
        @SerializedName("url")
        val url: String?
    )
}
