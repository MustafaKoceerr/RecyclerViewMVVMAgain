package com.kocerlabs.recylerviewwithmvvm.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

object Coroutines {
    // work alıp callback veren fonksiyon.
    fun <T : Any> ioThenMain(work: suspend (() -> T?), callback: ((T?) -> Unit)) {

        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async rt@{
                return@rt work()
            }.await()

            callback(data)
        }
    }
}