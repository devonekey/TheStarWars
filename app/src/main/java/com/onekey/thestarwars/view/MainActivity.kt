package com.onekey.thestarwars.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onekey.thestarwars.R
import com.onekey.thestarwars.viewmodel.FilmViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val filmViewModel: FilmViewModel = ViewModelProvider
            .NewInstanceFactory()
            .create(FilmViewModel::class.java)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = FilmsAdapter().apply {
                filmViewModel.getFilms().observe(this@MainActivity, Observer { it ->
                    it.results!!.forEach {
                        add(it)
                    }
                })
            }
        }
    }
}