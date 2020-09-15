package com.onekey.thestarwars.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.onekey.thestarwars.data.Film
import com.onekey.thestarwars.data.source.FilmDataRepository
import com.onekey.thestarwars.data.source.FilmDataSource
import com.onekey.thestarwars.data.source.local.FilmLocalDataSource
import com.onekey.thestarwars.data.source.remote.FilmRemoteDataSource

class FilmViewModel(application: Application) : AndroidViewModel(application) {
    private var filmDataRepository: FilmDataRepository =
        FilmDataRepository(FilmLocalDataSource(application.baseContext), FilmRemoteDataSource)
    val films = MutableLiveData<List<Film>>()
    private val TAG = FilmViewModel::class.java.simpleName

    fun getFilms(): LiveData<List<Film>> {
        filmDataRepository.browse(object : FilmDataSource.OnBrowseSuccessListener {
            override fun onSuccess(films: List<Film>) {
                Log.d(
                    TAG, "onResponse" +
                            "\nExpected result..."
                )

                this@FilmViewModel.films.postValue(films)
            }
        }, object : FilmDataSource.OnBrowseFailedListener {
            override fun onFailure() {
                Log.d(
                    TAG, "onFailure"
                )
            }
        })

        return films
    }
}