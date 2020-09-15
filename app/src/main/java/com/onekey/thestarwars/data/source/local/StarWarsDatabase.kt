package com.onekey.thestarwars.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.onekey.thestarwars.data.Film

@Database(entities = [Film::class], version = 1)
abstract class StarWarsDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao

    companion object {
        private var INSTANCE: StarWarsDatabase? = null
        private val lock = Any()

        fun getInstance(context: Context): StarWarsDatabase {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = Room
                        .databaseBuilder(
                            context.applicationContext,
                            StarWarsDatabase::class.java, "StarWars.db"
                        )
                        .allowMainThreadQueries()
                        .build()
                }
                return INSTANCE!!
            }
        }
    }
}