package com.onekey.thestarwars.view

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.onekey.thestarwars.data.Film
import com.onekey.thestarwars.databinding.ViewHolderFilmBinding

class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding: ViewHolderFilmBinding = DataBindingUtil.bind(itemView)!!

    fun setFilm(film: Film) {
        binding.film = film
    }
}