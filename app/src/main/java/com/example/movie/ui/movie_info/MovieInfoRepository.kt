package com.example.movie.ui.movie_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.movie.core.netwrok.result.Resource
import com.example.movie.data.remote.RemoteDataSource
import com.example.movie.models.MovieInfo
import com.example.movie.models.Popular
import kotlinx.coroutines.Dispatchers

class MovieInfoRepository(private val dataSource: RemoteDataSource) {

    fun getInfoMovie(movieId: Int, apiKey: String) : LiveData<Resource<MovieInfo>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val response = dataSource.getInfoMovie(movieId, apiKey)
        emit(response)
    }

}