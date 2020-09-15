package com.onekey.thestarwars.data.source.local

import androidx.room.Dao
import androidx.room.Query
import com.onekey.thestarwars.data.Film

@Dao
interface FilmDao {
    @Query("SELECT * FROM films")
    fun browse(): List<Film>
}