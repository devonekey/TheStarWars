package com.onekey.thestarwars.data.source.remote

import android.util.Log
import com.onekey.thestarwars.data.Films
import com.onekey.thestarwars.data.source.FilmDataSource
import com.onekey.thestarwars.data.source.SWAPIClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object FilmRemoteDataSource : FilmDataSource {
    private val TAG = FilmRemoteDataSource::class.java.simpleName

    override fun browse(
        onBrowseSuccessListener: FilmDataSource.OnBrowseSuccessListener,
        onBrowseFailedListener: FilmDataSource.OnBrowseFailedListener
    ) {
        SWAPIClient
            .getInstance()
            .getFilms()
            .enqueue(object : Callback<Films> {
                override fun onResponse(call: Call<Films>, response: Response<Films>) {
                    Log.d(
                        TAG, "onResponse" +
                                "\nExpected result..." +
                                "\nurl : ${call.request().url()}"
                    )

                    if (response.body() != null) {
                        onBrowseSuccessListener.onSuccess(response.body()!!)
                    }
                }

                override fun onFailure(call: Call<Films>, t: Throwable?) {
                    Log.d(
                        TAG, "onFailure" +
                                "\nurl : ${call.request().url()}" +
                                "\nmessage : ${t!!.message}"
                    )

                    onBrowseFailedListener.onFailure()
                }
            })
    }
}