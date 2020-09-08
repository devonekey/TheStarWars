package com.onekey.thestarwars.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.onekey.thestarwars.R
import com.onekey.thestarwars.data.Films
import com.onekey.thestarwars.data.source.FilmDataRepository
import com.onekey.thestarwars.data.source.FilmDataSource
import com.onekey.thestarwars.data.source.remote.FilmRemoteDataSource
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var filmDataRepository: FilmDataRepository
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = FilmsAdapter()

        recyclerView.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            this.adapter = adapter
        }

        filmDataRepository = FilmDataRepository(FilmRemoteDataSource)
        filmDataRepository.browse(object : FilmDataSource.OnBrowseSuccessListener {
            override fun onSuccess(films: Films) {
                Log.d(
                    TAG, "onResponse" +
                            "\nExpected result..."
                )

                films.results!!.forEach {
                    adapter.add(it)
                }
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