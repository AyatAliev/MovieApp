package com.example.filminfo.data.remote

import NewsBase
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    /*News List*/
 @GET("top-headlines")
 suspend fun getFilmInfo(
        @Query("country") country: String,
        @Query("apiKey") key: String,
        @Query("pageSize") size: Int,
        @Query("page") page: Int
 ): Response<NewsBase>


}