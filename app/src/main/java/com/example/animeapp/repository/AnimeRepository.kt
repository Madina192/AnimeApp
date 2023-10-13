package com.example.animeapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.animeapp.models.Anime
import com.example.animeapp.models.AnimeModel
import com.example.animeapp.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimeRepository {
    fun getAnimes(page : Int): MutableLiveData<ArrayList<Anime>> {
        val data = MutableLiveData<ArrayList<Anime>>()
        RetrofitService.api.getAnimes(page = page).enqueue(object : Callback<AnimeModel>{
            override fun onResponse(call: Call<AnimeModel>, response: Response<AnimeModel>) {
                data.postValue(response.body()?.data!!)
            }

            override fun onFailure(call: Call<AnimeModel>, t: Throwable) {
                Log.e("lol", "onFailure: ${t.message}")
            }

        })
        return data
    }

    fun getAnime(id : String): LiveData<Anime> {
        val anime = MutableLiveData<Anime>()
        RetrofitService.api.getAnimeById(id).enqueue(object : Callback<Anime>{
            override fun onResponse(call: Call<Anime>, response: Response<Anime>) {
                anime.value = response.body()
            }

            override fun onFailure(call: Call<Anime>, t: Throwable) {
                Log.e("lol", "onFailure: ${t.message}")
            }
        })
        return anime
    }
}

