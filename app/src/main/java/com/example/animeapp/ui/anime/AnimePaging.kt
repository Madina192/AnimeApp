package com.example.animeapp.ui.anime

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.animeapp.models.Anime
import com.example.animeapp.retrofit.RetrofitService

class AnimePaging(var page: Int) : PagingSource<Int, Anime>() {
    override fun getRefreshKey(state: PagingState<Int, Anime>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Anime> {
        val page = params.key ?: 1

        return try {
            val data = RetrofitService.api.getAnimes(page = page)

            LoadResult.Page(
                data = data.body()?.data!!,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (data.body()?.data?.isEmpty()!!) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}