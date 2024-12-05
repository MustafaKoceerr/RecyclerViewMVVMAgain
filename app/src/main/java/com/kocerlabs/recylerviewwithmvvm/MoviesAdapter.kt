package com.kocerlabs.recylerviewwithmvvm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kocerlabs.recylerviewwithmvvm.data.network.model.MoviesResponseItem
import com.kocerlabs.recylerviewwithmvvm.databinding.RecyclerviewMovieBinding

class MoviesAdapter(
    private val movies: List<MoviesResponseItem>,
    private val listener: RecyclerViewClickListener
) : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    inner class MoviesViewHolder(
        val recyclerviewMovieBinding: RecyclerviewMovieBinding
    ) : RecyclerView.ViewHolder(recyclerviewMovieBinding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder =
        MoviesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.recyclerview_movie,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        with(holder.recyclerviewMovieBinding) {
            movie = movies[position]

            buttonBook.setOnClickListener {
                // todo whatever you want
                listener.onRecyclerViewItemClick(it, movies[position])
            }
            layoutLike.setOnClickListener {
                listener.onRecyclerViewItemClick(it, movies[position])
            }
            /**
             * Movies fragment'a callback göndermek istiyorum diyelim. Ne yapmalıyım?
             * Bir interface tanımlamalısın.
             */
        }
        // layout'taki movie variable'ı ile pozisyondaki movie'yi bağlıyoruz.
    }
}