package com.example.androidtraining_m05.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    val overview: String,
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("vote_average")
    val voteAverage: Double
)