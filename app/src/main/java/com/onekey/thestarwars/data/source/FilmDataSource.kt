package com.onekey.thestarwars.data.source

import com.onekey.thestarwars.data.Films

interface FilmDataSource {
    interface OnBrowseSuccessListener {
        fun onSuccess(films: Films)
    }

    interface OnBrowseFailedListener {
        fun onFailure()
    }

    fun browse(
        onBrowseSuccessListener: OnBrowseSuccessListener,
        onBrowseFailedListener: OnBrowseFailedListener
    )
}