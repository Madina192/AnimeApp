package com.example.animeapp.ui.anime

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.animeapp.models.Anime
import com.example.animeapp.repository.AnimeRepository

class AnimeViewModel : ViewModel() {

    var repository = AnimeRepository()
    private val _animeList = MutableLiveData<ArrayList<Anime>>()
    val animeList = _animeList
    //var anime = MutableLiveData<Anime>()
    val query = MutableLiveData("")

//    MutableLiveDataval list = query.switchMap {
//        Pager(PagingConfig(pageSize = 10)) {
//            AnimePaging()
//        }
//    }

    fun getAnimes(page : Int) : LiveData<ArrayList<Anime>>{
        Log.d("ololo", "getAnimesViewModel: ${_animeList}")
        return repository.getAnimes(page = page)
    }

    fun getAnimeById(id : String) : LiveData<Anime>{
        Log.d("ololo", "getAnimeByIdViewModel: ${repository.getAnime(id)}")
        return repository.getAnime(id)
    }
}