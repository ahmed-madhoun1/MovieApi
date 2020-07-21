package com.example.movieapi.model

data class MovieModel(
    val genre: List<String>,
    val image: String,
    val rating: String,
    val releaseYear: String,
    val title: String
)