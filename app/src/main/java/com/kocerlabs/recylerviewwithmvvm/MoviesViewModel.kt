package com.kocerlabs.recylerviewwithmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kocerlabs.recylerviewwithmvvm.data.MoviesRepository
import com.kocerlabs.recylerviewwithmvvm.data.network.model.MoviesResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(
    private val repository: MoviesRepository
) : ViewModel() {
    // communicate with movies repository
    private val _movies = MutableLiveData<List<MoviesResponseItem>>()
    val movies: LiveData<List<MoviesResponseItem>>
        get() = _movies

    fun getMovies() = viewModelScope.launch {
        _movies.value = repository.getMovies()
    }


}