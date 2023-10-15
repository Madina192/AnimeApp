package com.example.animeapp.ui.anime

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.animeapp.databinding.ItemAnimeBinding
import com.example.animeapp.models.Anime

class AnimeAdapter : PagingDataAdapter<Anime, AnimeAdapter.AnimeViewHolder>(DIFF_UTIL) {

    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<Anime>() {
            override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
                return oldItem == newItem
            }

        }
    }

    private var list = listOf<Anime>()
    fun setList(listOfAnime: ArrayList<Anime>) {
        list = listOfAnime
    }

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
            binding.tvTitle.text = anime.attributes.titles.en
            binding.tvAge.text = anime.attributes.ageRatingGuide
            binding.ivAnime.load(anime.attributes.posterImage.small)
        }
    }
}