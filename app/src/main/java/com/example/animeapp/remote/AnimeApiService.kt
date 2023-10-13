package com.example.animeapp.remote

import com.example.animeapp.models.Anime
import com.example.animeapp.models.AnimeModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AnimeApiService {
    @GET("anime")
    fun getAnimes(
        @Query("page[limit]") limit: Int? = 10,
        @Query("page[offset]") page: Int
    ): Call<AnimeModel>

    @GET("anime/{id}")
    fun getAnimeById(
        @Path("id") id: String
    ): Call<Anime>

}