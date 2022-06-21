package com.dhandroid2022.projetointegrador.data.comicDTO

import com.dhandroid2022.projetointegrador.data.heroDTO.HeroListResponse
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicAPI {

    @GET("characters/{characterId}/comics?apikey=${com.dhandroid2022.projetointegrador.data.utils.PUBLIC_KEY}&limit=100")
    suspend fun fetchHeroComicList(
        @Query("characterId") heroID: String,
        @Query("ts") ts: Long,
        @Query("hash") hash: String,
        @Query("offset") offset: String,
    ): ComicListResponse

    @GET("characters/{comicId}?apikey=${com.dhandroid2022.projetointegrador.data.utils.PUBLIC_KEY}")
    suspend fun fetchComicDetails(
        @Path("comicId") comicID: String,
        @Query("ts") ts: Long,
        @Query("hash") hash: String,
    ): ComicResponse

}