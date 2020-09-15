package com.onekey.thestarwars.data.source

import com.onekey.thestarwars.data.Film

class FilmDataRepository(
    val filmRemoteDataSource: FilmDataSource
) : FilmDataSource {
    val cache: MutableList<Film> = mutableListOf()

    override fun browse(
        onBrowseSuccessListener: FilmDataSource.OnBrowseSuccessListener,
        onBrowseFailedListener: FilmDataSource.OnBrowseFailedListener
    ) {
        filmRemoteDataSource.browse(object : FilmDataSource.OnBrowseSuccessListener {
            override fun onSuccess(films: List<Film>) {
                cache.addAll(films)

                onBrowseSuccessListener.onSuccess(films)
            }
        }, onBrowseFailedListener)
    }
}