package com.example.animeapp.ui.anime

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.animeapp.databinding.FragmentAnimeBinding

class AnimeFragment : Fragment() {

    private var _binding: FragmentAnimeBinding? = null
    private val binding get() = _binding!!
    private val animeViewModel: AnimeViewModel by viewModels()
    private val adapter = AnimeAdapter()
    var page = 0
    var id = "1"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        getAnimeById()
        //getAnimes()
//        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                super.onScrollStateChanged(recyclerView, newState)
//                if (!recyclerView.canScrollVertically(1)) {
//                    page += 5
//                    //getAnimes()
//                }
//            }
//        })
    }

//    fun getAnimes() {
//        animeViewModel.getAnimes(page)
//        animeViewModel.animeList.observe(requireActivity()) { animes ->
//            adapter.list = animes
//        }
//    }

    fun getAnimeById() {
        //animeViewModel.getAnimeById(id)
        animeViewModel.getAnimeById(id).observe(requireActivity()) {anime ->
            adapter.list.add(anime)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}