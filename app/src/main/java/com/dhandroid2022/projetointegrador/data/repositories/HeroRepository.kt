package com.dhandroid2022.projetointegrador.data.repositories

import com.dhandroid2022.projetointegrador.data.heroAPI
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroResponse
import com.dhandroid2022.projetointegrador.data.utils.HashGenerator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HeroRepository {

    private val api = heroAPI

    suspend fun fetchHeroList(): HeroResponse = withContext(Dispatchers.IO) {
        val ts = System.currentTimeMillis()
        api.fetchHeroList(ts, HashGenerator.getHash(ts))
    }
}