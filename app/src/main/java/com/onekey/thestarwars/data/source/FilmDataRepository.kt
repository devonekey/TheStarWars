package com.onekey.thestarwars.data.source

import android.util.Log
import com.onekey.thestarwars.data.Film

class FilmDataRepository(
    val filmLocalDataSource: FilmDataSource,
    val filmRemoteDataSource: FilmDataSource
) : FilmDataSource {
    val cache: MutableList<Film> = mutableListOf()
    private val TAG = FilmDataRepository::class.java.simpleName

    override fun browse(
        onBrowseSuccessListener: FilmDataSource.OnBrowseSuccessListener,
        onBrowseFailedListener: FilmDataSource.OnBrowseFailedListener
    ) {
        if (cache.isNotEmpty()) {
            Log.d(TAG, "At cache...")

            onBrowseSuccessListener.onSuccess(cache)

            return
        }

        filmLocalDataSource.browse(object : FilmDataSource.OnBrowseSuccessListener {
            override fun onSuccess(films: List<Film>) {
                Log.d(TAG, "At local...")

                cache.addAll(films)

                onBrowseSuccessListener.onSuccess(films)
            }
        }, object : FilmDataSource.OnBrowseFailedListener {
            override fun onFailure() {
                filmRemoteDataSource.browse(object : FilmDataSource.OnBrowseSuccessListener {
                    override fun onSuccess(films: List<Film>) {
                        Log.d(TAG, "At remote...")

                        cache.addAll(films)

                        onBrowseSuccessListener.onSuccess(films)
                    }
                }, onBrowseFailedListener)
            }
        })
    }
}