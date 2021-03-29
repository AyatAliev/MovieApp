package com.example.filminfo.ui.home

import NewsBase
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.filminfo.core.netwrok.result.Resource
import com.example.filminfo.data.remote.RemoteDataSource
import kotlinx.coroutines.Dispatchers

class HomeRepository(private val dataSource: RemoteDataSource) {

    fun getFilmInfo() : LiveData<Resource<NewsBase>> = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        val response = dataSource.getFilmInfo()
        emit(response)
    }

}