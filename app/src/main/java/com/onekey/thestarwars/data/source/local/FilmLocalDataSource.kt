package com.onekey.thestarwars.data.source.local

import android.content.Context
import com.onekey.thestarwars.data.source.FilmDataSource

class FilmLocalDataSource(context: Context) : FilmDataSource {
    val filmDao = StarWarsDatabase.getInstance(context).filmDao()

    override fun browse(
        onBrowseSuccessListener: FilmDataSource.OnBrowseSuccessListener,
        onBrowseFailedListener: FilmDataSource.OnBrowseFailedListener
    ) {
        val films = filmDao.browse()

        if (films.isNotEmpty()) {
            onBrowseSuccessListener.onSuccess(films)
        } else {
            onBrowseFailedListener.onFailure()
        }
    }
}