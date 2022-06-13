package com.dhandroid2022.projetointegrador.data.repositories

import androidx.work.WorkManager
import com.dhandroid2022.projetointegrador.data.heroAPI
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroListResponse
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroResponse
import com.dhandroid2022.projetointegrador.data.utils.HashGenerator
import com.google.gson.JsonElement
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HeroRepository {

    private val api = heroAPI

    suspend fun fetchHeroList(offset: String): HeroListResponse = withContext(Dispatchers.IO) {
        val ts = System.currentTimeMillis()
        api.fetchHeroList(ts, HashGenerator.getHash(ts), offset)
    }

    suspend fun fetchHeroDetails(heroID: String): HeroResponse = withContext(Dispatchers.IO) {
        val ts = System.currentTimeMillis()
        api.fetchHeroDetails(heroID, ts, HashGenerator.getHash(ts))
    }
}