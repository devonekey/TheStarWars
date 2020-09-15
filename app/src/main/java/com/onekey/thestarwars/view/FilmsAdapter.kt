package com.onekey.thestarwars.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.onekey.thestarwars.R
import com.onekey.thestarwars.databinding.ActivityMainBinding

class FilmsAdapter(root: View) : RecyclerView.Adapter<FilmViewHolder>() {
    private val binding: ActivityMainBinding = DataBindingUtil.getBinding(root)!!

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder =
        FilmViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_holder_film, parent, false)
        )

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) =
        holder.setFilm(binding.viewModel!!.films.value!![holder.adapterPosition])

    override fun getItemCount(): Int = binding.viewModel!!.films.value?.size ?: 0
}