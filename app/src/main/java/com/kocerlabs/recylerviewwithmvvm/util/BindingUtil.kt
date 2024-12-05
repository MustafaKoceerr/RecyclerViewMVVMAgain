package com.kocerlabs.recylerviewwithmvvm.util

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("image")
fun loadImage(view: ImageView, url: String) {
    Glide.with(view)
        .load(url)
        .into(view)
}

@BindingAdapter("genres")
fun loadGenres(view: TextView, genres: ArrayList<String>) {
    val builder = StringBuilder()
    genres.forEach {
        builder.append(it)
        builder.append("\n")
    }
    view.text = builder.toString()
}
