package com.onekey.thestarwars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Retrofit
            .Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SWAPI::class.java)
            .getPlanet(1)
            .enqueue(object : Callback<Planet> {
                override fun onResponse(call: Call<Planet>, response: Response<Planet>) {
                    Log.d(
                        TAG, "onResponse" +
                                "\nExpected result..." +
                                "\nurl : ${call.request().url()}"
                    )
                }

                override fun onFailure(call: Call<Planet>, t: Throwable?) {
                    Log.d(
                        TAG, "onFailure" +
                                "\nurl : ${call.request().url()}"
                    )
                }
            })
    }
}