package com.example.animeapp.retrofit

import com.example.animeapp.remote.AnimeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    var retrofit = Retrofit.Builder().baseUrl("https://kitsu.io/api/edge/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    var api = retrofit.create(AnimeApiService::class.java)
}