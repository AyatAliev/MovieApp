package com.example.movie.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.movie.BuildConfig.API_KEY
import com.example.movie.core.netwrok.result.Resource
import com.example.movie.models.Popular
import com.example.movie.core.ui.BaseViewModel
import java.util.*

class HomeViewModel(private val repository: HomeRepository) : BaseViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    private val _moviePopular = MutableLiveData<Boolean>()

    val moviePopular: LiveData<Resource<Popular>> = _moviePopular.switchMap {
        repository.moviePopular(API_KEY)
    }

   init {
       _moviePopular.postValue(true)
   }
}