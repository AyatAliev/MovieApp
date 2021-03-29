package com.example.filminfo.ui.home

import NewsBase
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.example.filminfo.core.netwrok.result.Resource
import com.heliostech.realoptimizer.core.ui.BaseViewModel

class HomeViewModel(private val repository: HomeRepository) : BaseViewModel() {

    private val _filmInfo = MutableLiveData<Boolean>()
    val filmInfo: LiveData<Resource<NewsBase>> = _filmInfo.switchMap {
        repository.getFilmInfo()
    }

    init {
        _filmInfo.postValue(true)
    }


}