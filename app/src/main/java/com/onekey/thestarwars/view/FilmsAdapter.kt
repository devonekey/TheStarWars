package com.onekey.thestarwars.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onekey.thestarwars.R
import com.onekey.thestarwars.data.Film

class FilmsAdapter : RecyclerView.Adapter<FilmViewHolder>() {
    val films = mutableListOf<Film>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder =
        FilmViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.view_holder_film, parent, false)
        )

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) =
        holder.setFilm(films[position])

    override fun getItemCount(): Int = films.size

    fun add(film: Film) {
        films.add(film)
        notifyDataSetChanged()
    }
}