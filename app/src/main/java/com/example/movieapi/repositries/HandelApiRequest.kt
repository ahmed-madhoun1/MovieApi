package com.example.movieapi.repositries

import retrofit2.Response
import java.io.IOException

abstract class HandelApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw ApiRequestException(
                response.code().toString()
            )
        }

    }

}

class ApiRequestException(message: String) : IOException(message) {

}
