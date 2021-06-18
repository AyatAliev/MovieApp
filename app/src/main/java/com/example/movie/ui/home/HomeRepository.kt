package com.example.movie.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.movie.core.netwrok.result.Resource
import com.example.movie.data.remote.RemoteDataSource
import com.example.movie.models.Popular
import kotlinx.coroutines.Dispatchers

class HomeRepository(private val dataSource: RemoteDataSource) {

    fun moviePopular(apiKey: String) : LiveData<Resource<Popular>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val response = dataSource.moviePopular(apiKey)
        emit(response)
    }

}