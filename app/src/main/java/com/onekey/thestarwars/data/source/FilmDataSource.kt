package com.onekey.thestarwars.data.source

import com.onekey.thestarwars.data.Film

interface FilmDataSource {
    interface OnBrowseSuccessListener {
        fun onSuccess(films: List<Film>)
    }

    interface OnBrowseFailedListener {
        fun onFailure()
    }

    fun browse(
        onBrowseSuccessListener: OnBrowseSuccessListener,
        onBrowseFailedListener: OnBrowseFailedListener
    )
}