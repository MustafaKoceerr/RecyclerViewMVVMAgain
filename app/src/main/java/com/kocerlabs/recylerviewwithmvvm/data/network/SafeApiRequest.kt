package com.kocerlabs.recylerviewwithmvvm.data.network

import retrofit2.Response
import java.io.IOException

abstract class SafeApiRequest {

    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {

        try {
            val response = call.invoke()
            if (response.isSuccessful) {
                response.body()?.let {
                    return it
                }
                throw ApiException("Response body shouldn't be null!")
            } else {
                // todo handle exception
                throw ApiException(response.code().toString())
            }
        } catch (e: Exception) {
            throw ApiException("Catch: ${e.message}")
        }
    }
}


class ApiException(message: String) : IOException(message) {

}