package com.drassapps.androidchallenge.ui.common

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(crossinline factory: () -> T): T {

    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>): U = factory() as U
    }

    return ViewModelProvider(this, vmFactory).get()
}

fun <T> CoroutineScope.collectFlow(flow: Flow<T>, body: suspend (T) -> Unit) {
    flow.onEach { body(it) }.launchIn(this)
}

@ExperimentalCoroutinesApi
val RecyclerView.lastVisible: Flow<Int> get() = callbackFlow<Int> {
    val lm = layoutManager as LinearLayoutManager

    val listener = object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            if (!recyclerView.canScrollVertically(1)) {
                offer(lm.findLastVisibleItemPosition())
            }
        }
    }
    addOnScrollListener(listener)
    awaitClose { removeOnScrollListener(listener) }

}.conflate()
