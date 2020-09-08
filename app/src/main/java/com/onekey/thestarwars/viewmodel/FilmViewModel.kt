package com.onekey.thestarwars.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.onekey.thestarwars.data.Films
import com.onekey.thestarwars.data.source.FilmDataRepository
import com.onekey.thestarwars.data.source.FilmDataSource
import com.onekey.thestarwars.data.source.remote.FilmRemoteDataSource

class FilmViewModel : ViewModel() {
    private var filmDataRepository: FilmDataRepository =
        FilmDataRepository(FilmRemoteDataSource)
    private val films = MutableLiveData<Films>()
    private val TAG = FilmViewModel::class.java.simpleName

    fun getFilms(): LiveData<Films> {
        filmDataRepository.browse(object : FilmDataSource.OnBrowseSuccessListener {
            override fun onSuccess(films: Films) {
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