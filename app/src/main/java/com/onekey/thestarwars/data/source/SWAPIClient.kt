package com.onekey.thestarwars.data.source

import com.google.gson.GsonBuilder
import com.onekey.thestarwars.data.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

object SWAPIClient {
    private val swapi: SWAPI
    private val BASE_URL = "https://swapi.dev/api/"
    private val DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'"

    init {
        swapi = Retrofit.Builder().apply {
            baseUrl(BASE_URL)
            addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().setDateFormat(DATE_FORMAT).create())
            )
            client(OkHttpClient())
        }.build().create(SWAPI::class.java)
    }

    fun getInstance(): SWAPI = swapi

    @Suppress("unused")
    interface SWAPI {
        @GET("/")
        fun getRoot(): Call<Root>

        @GET("people/")
        fun getPeople(): Call<List<Planet>>

        @GET("films/")
        fun getFilms(): Call<Films>

        @GET("films/{id}/")
        fun getFilm(@Path("id") id: Int): Call<Film>

        @GET("starship/{id}/")
        fun getStarship(@Path("id") id: Int): Call<Starship>

        @GET("vehicles/{id}/")
        fun getVehicle(@Path("id") id: Int): Call<Vehicle>

        @GET("species/{id}/")
        fun getSpecies(@Path("id") id: Int): Call<Species>

        @GET("planets/{id}/")
        fun getPlanet(@Path("id") id: Int): Call<Planet>
    }
}