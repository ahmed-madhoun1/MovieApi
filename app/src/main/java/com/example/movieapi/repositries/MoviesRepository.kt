package com.example.movieapi.repositries

import com.example.movieapi.api.MovieApiInterface
import com.example.movieapi.repositries.HandelApiRequest

class MoviesRepository(private val api: MovieApiInterface) : HandelApiRequest() {

    suspend fun getMovies() = apiRequest { api.getMovies() }

}
