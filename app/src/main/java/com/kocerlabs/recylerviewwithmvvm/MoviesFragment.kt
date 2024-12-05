package com.kocerlabs.recylerviewwithmvvm

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kocerlabs.recylerviewwithmvvm.data.MoviesRepository
import com.kocerlabs.recylerviewwithmvvm.data.network.MovieApi
import com.kocerlabs.recylerviewwithmvvm.data.network.model.MoviesResponseItem
import com.kocerlabs.recylerviewwithmvvm.databinding.FragmentMoviesBinding
import com.kocerlabs.recylerviewwithmvvm.util.showSnackbar


class MoviesFragment() : Fragment(), RecyclerViewClickListener {
    val TAG = "MoviesFragment"

    private lateinit var viewModel: MoviesViewModel
    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_movies, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val api = MovieApi()
        val repository = MoviesRepository(api)
        val factory = MoviesViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MoviesViewModel::class.java)

        viewModel.getMovies()
        observers()
    }

    private fun observers() {
        viewModel.movies.observe(viewLifecycleOwner, Observer {
            with(binding.recyclerViewMovies) {
                adapter = MoviesAdapter(it, this@MoviesFragment) // 'it' Movies verisi olmalı
                layoutManager = LinearLayoutManager(requireContext()) // Dikey liste için
                setHasFixedSize(true) // Performans optimizasyonu
            }
        })
    }

    override fun onRecyclerViewItemClick(view: View, movie: MoviesResponseItem) {
        when (view.id) {
            R.id.button_book -> {
                requireView().showSnackbar(movie.toString())
                Log.d(TAG, "Movie: $movie")
            }

            R.id.layout_like -> {
                requireView().showSnackbar(movie.toString())
                Log.d(TAG, "Movie: $movie")
            }
        }

    }
}