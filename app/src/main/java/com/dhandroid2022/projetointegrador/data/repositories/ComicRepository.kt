package com.dhandroid2022.projetointegrador.data.repositories

import com.dhandroid2022.projetointegrador.data.comicAPI
import com.dhandroid2022.projetointegrador.data.comicDTO.ComicListResponse
import com.dhandroid2022.projetointegrador.data.comicDTO.ComicResponse
import com.dhandroid2022.projetointegrador.data.utils.HashGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ComicRepository {

    private val api = comicAPI

    suspend fun fetchComicList(heroID: String, offset: String): ComicListResponse = withContext(Dispatchers.IO) {
        val ts = System.currentTimeMillis()
        api.fetchComicList(heroID, ts, HashGenerator.getHash(ts), offset)
    }

    suspend fun fetchComicDetails(comicID: String): ComicResponse = withContext(Dispatchers.IO) {
        val ts = System.currentTimeMillis()
        api.fetchComicDetails(comicID, ts, HashGenerator.getHash(ts))
    }
}