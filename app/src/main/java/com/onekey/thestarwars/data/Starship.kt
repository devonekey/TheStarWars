package com.onekey.thestarwars.data

import com.google.gson.annotations.SerializedName
import java.util.Date

class Starship {
    @SerializedName("MGTL")
    var mGLT: String? = null
    var cargo_capacity: String? = null
    var consumables: String? = null
    var cost_in_credits: String? = null
    var created: Date? = null
    var crew: String? = null
    var edited: Date? = null
    var hyperdrive_rating: String? = null
    var length: String? = null
    var manufacturer: String? = null
    var max_atmosphering_speed: String? = null
    var model: String? = null
    var name: String? = null
    var passengers: String? = null
    var films: List<String>? = null
    var pilots: List<Any>? = null
    var starship_class: String? = null
    var url: String? = null
}