package com.example.movie.data.remote

import com.example.movie.models.MovieInfo
import com.example.movie.models.Popular
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    /* Home Start */
    @GET("/3/movie/popular")
    suspend fun moviePopular(
        @Query("api_key") apiKey: String
    ): Response<Popular>
    /*Home End */

    /*Movie Info Start*/
    @GET("3/movie/{id})")
    suspend fun getInfoMovie(
        @Path(value = "id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Response<MovieInfo>
    /*Movie Info End*/

}