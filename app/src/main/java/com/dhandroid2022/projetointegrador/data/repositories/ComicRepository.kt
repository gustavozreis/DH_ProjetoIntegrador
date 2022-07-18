package com.dhandroid2022.projetointegrador.data.repositories

import com.dhandroid2022.projetointegrador.data.comicAPI
import com.dhandroid2022.projetointegrador.data.comicDTO.ComicListResponse
import com.dhandroid2022.projetointegrador.data.comicDTO.ComicResponse
import com.dhandroid2022.projetointegrador.data.utils.ApiResult
import com.dhandroid2022.projetointegrador.data.utils.HashGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ComicRepository {

    private val api = comicAPI

    suspend fun fetchComicList(heroID: String, offset: String): ApiResult<ComicListResponse> =
        withContext(Dispatchers.IO) {
            try {
                val ts = System.currentTimeMillis()
                val comicListResponse =
                    api.fetchComicList(heroID, ts, HashGenerator.getHash(ts), offset)
                return@withContext ApiResult.Success(data = comicListResponse)
            } catch (e: Exception) {
                return@withContext ApiResult.Error
            }

        }

    suspend fun fetchComicDetails(comicID: String): ApiResult<ComicResponse> =
        withContext(Dispatchers.IO) {
            try {
                val ts = System.currentTimeMillis()
                val comicResponse = api.fetchComicDetails(comicID, ts, HashGenerator.getHash(ts))
                return@withContext ApiResult.Success(data = comicResponse)
            } catch (e: Exception) {
                return@withContext ApiResult.Error
            }

        }
}