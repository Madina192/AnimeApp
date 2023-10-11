package com.example.animeapp.remote

import com.example.animeapp.models.AnimeModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeApiService {
    @GET("anime/")
    fun getAnime(
        @Query("q") keyWord: String,
        @Query("key") key: String = "38419248-534f53ef765c278655a0fd6be",
        @Query("per_page") perPage: Int = 3,
        @Query("page") page: Int
    ): Response<AnimeModel>
}