package com.onekey.thestarwars.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.onekey.thestarwars.data.Film
import kotlinx.android.synthetic.main.view_holder_film.view.*

class FilmViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setFilm(film: Film) {
        itemView.title.text = film.title!!
    }
}