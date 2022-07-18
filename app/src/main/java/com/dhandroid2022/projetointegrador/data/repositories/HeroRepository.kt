package com.dhandroid2022.projetointegrador.data.repositories

import android.util.Log
import com.dhandroid2022.projetointegrador.data.heroAPI
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroListResponse
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroResponse
import com.dhandroid2022.projetointegrador.data.utils.ApiResult
import com.dhandroid2022.projetointegrador.data.utils.HashGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HeroRepository() {

    private val api = heroAPI

    suspend fun fetchHeroList(offset: String): ApiResult<HeroListResponse> = withContext(Dispatchers.IO) {
        try {
            val ts = System.currentTimeMillis()
            val heroListResponse = api.fetchHeroList(ts, HashGenerator.getHash(ts), offset)
            return@withContext ApiResult.Success(data = heroListResponse)
        } catch (e: Exception) {
            Log.e("ERRO", e.printStackTrace().toString())
            return@withContext ApiResult.Error
        }
    }

    /*suspend fun fetchHeroList(offset: String): HeroListResponse = withContext(Dispatchers.IO) {
        try {
            val ts = System.currentTimeMillis()
            api.fetchHeroList(ts, HashGenerator.getHash(ts), offset)
        } catch (e: Exception) {
            Log.e("ERRO", e.printStackTrace().toString())
            throw e
        }
    }*/

    suspend fun fetchHeroDetails(heroID: String): ApiResult<HeroResponse> = withContext(Dispatchers.IO) {
        try {
            val ts = System.currentTimeMillis()
            val heroResponse = api.fetchHeroDetails(heroID, ts, HashGenerator.getHash(ts))
            return@withContext ApiResult.Success(data = heroResponse)
        } catch (e: Exception){
            android.util.Log.e("ERRO", e.printStackTrace().toString())
            return@withContext com.dhandroid2022.projetointegrador.data.utils.ApiResult.Error
        }

    }

    /*suspend fun fetchHeroDetails(heroID: String): HeroResponse = withContext(Dispatchers.IO) {
        val ts = System.currentTimeMillis()
        api.fetchHeroDetails(heroID, ts, HashGenerator.getHash(ts))
    }*/
}