package com.dhandroid2022.projetointegrador.data.heroDTO

import retrofit2.http.GET
import retrofit2.http.Query
import javax.crypto.Cipher.PUBLIC_KEY

interface HeroAPI {

    @GET("characters?apikey=${com.dhandroid2022.projetointegrador.data.utils.PUBLIC_KEY}&limit=100")
    suspend fun fetchHeroList(
        @Query("ts") ts: Long,
        @Query("hash") hash: String,
        @Query("offset") offset: String,
    ): HeroResponse

}