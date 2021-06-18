package com.example.movie.data.remote

import com.example.movie.core.netwrok.BaseDataSource
import org.intellij.lang.annotations.Language
import org.koin.dsl.module

val remoteDataSourceModule = module {
    factory { RemoteDataSource(get()) }
}

class RemoteDataSource(private val apiService: ApiService) : BaseDataSource() {

    suspend fun moviePopular(apiKey: String) = getResult { apiService.moviePopular(apiKey) }

    suspend fun getInfoMovie(movieId: Int,apiKey: String) = getResult { apiService.getInfoMovie(movieId,apiKey) }

}
