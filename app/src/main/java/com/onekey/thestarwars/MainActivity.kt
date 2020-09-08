package com.onekey.thestarwars

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.onekey.thestarwars.data.Films
import com.onekey.thestarwars.data.source.FilmDataRepository
import com.onekey.thestarwars.data.source.FilmDataSource
import com.onekey.thestarwars.data.source.remote.FilmRemoteDataSource

class MainActivity : AppCompatActivity() {
    lateinit var filmDataRepository: FilmDataRepository
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        filmDataRepository = FilmDataRepository(FilmRemoteDataSource)
        filmDataRepository.browse(object : FilmDataSource.OnBrowseSuccessListener {
            override fun onSuccess(films: Films) {
                Log.d(
                    TAG, "onResponse" +
                            "\nExpected result..."
                )
            }
        }, object : FilmDataSource.OnBrowseFailedListener {
            override fun onFailure() {
                Log.d(
                    TAG, "onFailure"
                )
            }
        })
    }
}