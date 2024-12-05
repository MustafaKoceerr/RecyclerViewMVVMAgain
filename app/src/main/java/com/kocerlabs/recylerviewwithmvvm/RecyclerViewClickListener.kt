package com.kocerlabs.recylerviewwithmvvm

import android.view.View
import com.kocerlabs.recylerviewwithmvvm.data.network.model.MoviesResponseItem

interface RecyclerViewClickListener {

    // hangi view'in tıklandığını öğrenmek için view parametresi veriyorum,
    // hangi nesneyi göndermek istiyorsam onu veriyorum.
    fun onRecyclerViewItemClick(view: View, movie: MoviesResponseItem)
}