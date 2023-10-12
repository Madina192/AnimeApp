package com.example.animeapp.ui.anime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.animeapp.databinding.ItemAnimeBinding
import com.example.animeapp.models.Anime

class AnimeAdapter : Adapter<AnimeAdapter.AnimeViewHolder>() {

    var list = arrayListOf<Anime>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder =
        AnimeViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) : ViewHolder(binding.root) {
        fun onBind(anime: Anime) {
            binding.tvTitle.text = anime.data.attributes.titles.en
            binding.tvAge.text = anime.data.attributes.ageRatingGuide
            binding.ivAnime.load(anime.data.attributes.posterImage.small)
        }
    }
}