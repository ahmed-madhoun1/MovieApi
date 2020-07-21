package com.example.movieapi.api

import com.example.movieapi.model.MovieModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("movies.json")
    suspend fun getMovies(): Response<List<MovieModel>>


    companion object {
        operator fun invoke(): MovieApiInterface {
            return Retrofit.Builder()
                .baseUrl("https://api.androidhive.info/json/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(MovieApiInterface::class.java)
        }
    }

}
