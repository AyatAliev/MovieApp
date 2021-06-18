package com.example.movie.ui.movie_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.movie.BuildConfig
import com.example.movie.core.netwrok.result.Resource
import com.example.movie.core.ui.BaseViewModel
import com.example.movie.models.MovieInfo
import java.util.*

class MovieInfoViewModel(private val repository: MovieInfoRepository) : BaseViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    private val _getInfoMovie = MutableLiveData<Int>()

    val getInfoMovie: LiveData<Resource<MovieInfo>> = _getInfoMovie.switchMap { movieId ->
        repository.getInfoMovie(movieId,BuildConfig.API_KEY)
    }

    fun getInfoMovie(movieId: Int) {
        _getInfoMovie.postValue(movieId)
    }

}