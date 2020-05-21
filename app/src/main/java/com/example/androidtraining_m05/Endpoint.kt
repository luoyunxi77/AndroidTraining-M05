package com.example.androidtraining_m05

import com.example.androidtraining_m05.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Endpoint {

    @GET("/3/movie/550")
    fun getMovies(@Query("api_key") apiKey: String): Call<Movie>
}