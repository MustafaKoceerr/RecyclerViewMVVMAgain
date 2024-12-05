package com.kocerlabs.recylerviewwithmvvm.data

import com.kocerlabs.recylerviewwithmvvm.data.network.MovieApi
import com.kocerlabs.recylerviewwithmvvm.data.network.SafeApiRequest

class MoviesRepository(
    private val api: MovieApi
):SafeApiRequest() {

    suspend fun getMovies() = apiRequest { api.getMovies() }
}