package com.danil.data.network

import com.danil.domain.exception.Failure
import com.danil.domain.util.Either
import com.danil.network.FetchError
import com.danil.network.FilmResponseDTO
import com.danil.network.api.FilmsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FilmsNetworkDataSourceImpl @Inject constructor(
    private val filmsApi: FilmsApi,
): FilmsNetworkDataSource {


    override suspend fun loadFilms(): Either<FilmResponseDTO, Failure> =
        withContext(Dispatchers.IO) {
            return@withContext try {
                println("!@!@!@!@!@! 1")
                val response = filmsApi.loadFilms()
                Either.Left(response)
            } catch (e: Exception) {
                println("!@!@!@!@!@! 2 ${e}")
                Either.Right(FetchError.detectError(e))
            }
        }
}