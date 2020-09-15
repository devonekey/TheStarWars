package com.onekey.thestarwars.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.onekey.thestarwars.R
import com.onekey.thestarwars.databinding.ActivityMainBinding
import com.onekey.thestarwars.viewmodel.FilmViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
        val filmViewModel: FilmViewModel = ViewModelProvider
            .NewInstanceFactory()
            .create(FilmViewModel::class.java)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = FilmsAdapter(binding.root).apply {
                filmViewModel.getFilms().observe(this@MainActivity, Observer {
                    binding.films = it
                    notifyDataSetChanged()
                })
            }
        }
    }
}