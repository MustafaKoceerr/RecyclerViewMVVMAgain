package com.kocerlabs.recylerviewwithmvvm.data.network

import com.kocerlabs.recylerviewwithmvvm.data.network.model.MoviesResponseItem
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MovieApi {
    @GET("movies")
    suspend fun getMovies(): Response<List<MoviesResponseItem>>

    companion object {
        const val BASE_URL = "https://freetestapi.com/api/v1/"
        operator fun invoke(): MovieApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }
}