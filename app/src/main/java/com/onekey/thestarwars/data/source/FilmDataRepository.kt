package com.onekey.thestarwars.data.source

import com.onekey.thestarwars.data.Film
import com.onekey.thestarwars.data.Films

class FilmDataRepository(
    val filmRemoteDataSource: FilmDataSource
) : FilmDataSource {
    val cache: MutableList<Film> = mutableListOf()

    override fun browse(
        onBrowseSuccessListener: FilmDataSource.OnBrowseSuccessListener,
        onBrowseFailedListener: FilmDataSource.OnBrowseFailedListener
    ) {
        filmRemoteDataSource.browse(object : FilmDataSource.OnBrowseSuccessListener {
            override fun onSuccess(films: Films) {
                cache.addAll(films.results!!)

                onBrowseSuccessListener.onSuccess(films)
            }
        }, onBrowseFailedListener)
    }
}