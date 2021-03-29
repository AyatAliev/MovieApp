package com.example.filminfo.data.remote

import com.example.filminfo.BuildConfig
import com.example.filminfo.core.netwrok.BaseDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    factory { RemoteDataSource(get()) }
}

class RemoteDataSource(private val apiService: ApiService) : BaseDataSource() {

    private val pageSize = 10
    private val page = 3
    private val country = "us"

    suspend fun getFilmInfo() = getResult { apiService.getFilmInfo(
        country,BuildConfig.API_KEY,page,pageSize
    ) }

}
