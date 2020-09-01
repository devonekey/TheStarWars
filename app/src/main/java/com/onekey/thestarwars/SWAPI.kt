package com.onekey.thestarwars

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SWAPI {
    @GET("planets/{id}/")
    fun getPlanet(@Path("id") id: Int): Call<Planet>
}