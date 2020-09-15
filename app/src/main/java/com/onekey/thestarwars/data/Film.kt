package com.onekey.thestarwars.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "films")
class Film {
    @Ignore
    var characters: List<String>? = null

    @Ignore
    var created: Date? = null
    var director: String? = null

    @Ignore
    var edited: Date? = null

    @PrimaryKey
    var episode_id = 0
    var opening_crawl: String? = null

    @Ignore
    var planets: List<String>? = null
    var producer: String? = null
    var release_date: String? = null

    @Ignore
    var species: List<String>? = null

    @Ignore
    var starships: List<String>? = null
    var title: String? = null
    var url: String? = null

    @Ignore
    var vehicles: List<String>? = null
}