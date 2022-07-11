package com.dhandroid2022.projetointegrador.ui.Home.HeroDetails.viewmodel

import android.content.ContentValues
import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.lifecycle.*
import com.bumptech.glide.Glide.init
import com.dhandroid2022.projetointegrador.data.comicDTO.ComicDTO
import com.dhandroid2022.projetointegrador.data.favorites.DBHelper
import com.dhandroid2022.projetointegrador.data.favorites.FavoriteHero
import com.dhandroid2022.projetointegrador.data.favorites.FavoriteHeroDAO
import com.dhandroid2022.projetointegrador.data.favorites.FeedReaderContract
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroDTO
import com.dhandroid2022.projetointegrador.data.repositories.ComicRepository
import com.dhandroid2022.projetointegrador.data.repositories.HeroRepository
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch

class HeroDetailsFragmentViewModel(private val favoriteHeroDAO: FavoriteHeroDAO) : ViewModel() {

    private val heroRepository = HeroRepository()
    private val comicRepository = ComicRepository()

    private var _hero = MutableLiveData<HeroDTO>()
    val hero: MutableLiveData<HeroDTO>
        get() = _hero

    private var _comicList = MutableLiveData<List<ComicDTO>>(mutableListOf())
    val comicList: MutableLiveData<List<ComicDTO>>
        get() = _comicList

    private var heroIdFromArgs: String = ""

    private var _favoritesList = MutableLiveData<MutableList<FavoriteHero>>(mutableListOf())
    val favoritesList: MutableLiveData<MutableList<FavoriteHero>>
        get() = _favoritesList

    init {
        getFavoritesList()
    }

    fun getHeroDetails(heroID: String) {
        var hero: HeroDTO
        viewModelScope.launch {
            hero = heroRepository.fetchHeroDetails(heroID).data
            _hero.value = hero
        }
    }

    fun getComicList(heroID: String) {
        var comicList: MutableList<ComicDTO> = mutableListOf()
        try {
            viewModelScope.launch {
                val tempList = comicRepository.fetchComicList(heroID, "0").data.comicList
                for (comic in tempList) {
                    comicList.add(comic)
                }
                _comicList.value = comicList
            }
        } catch (e: Exception) {

        }
    }

    fun addToFavorites(
        heroId: String,
        heroName: String,
        heroThumbUrl: String,
        heroDescription: String,
    ) {

        viewModelScope.launch {
            val favToAdd = FavoriteHero(
                heroId.toInt(),
                heroName,
                heroThumbUrl,
                heroDescription,

            )
            favoriteHeroDAO.insert(favToAdd)
            getFavoritesList()
        }
    }

    fun removeFromFavorites(heroID: String) {
        viewModelScope.launch {
            favoriteHeroDAO.deleteHero(heroID.toInt())
            getFavoritesList()
        }
    }

    private fun getFavoritesList() {
        viewModelScope.launch {
            val tempList = favoriteHeroDAO.getAll()
            _favoritesList.value = tempList
        }

    }

    fun createPowers(id: String) : List<String> {

        val powerList = mutableListOf<String>()

        val sString = id.substring(3).toInt()
        val powerTotal = (sString * 777).toString()

        val power = "${powerTotal[0]}${powerTotal[1]}"
        val dextery = "${powerTotal[2]}${powerTotal[3]}"
        val inteligence = "${powerTotal[4]}${powerTotal[5]}"

        powerList.apply {
            add(power)
            add(dextery)
            add(inteligence)
        }

        return powerList
    }

}

class HeroDetailsFragmentViewModelFactory(private val favoriteHeroDao: FavoriteHeroDAO) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HeroDetailsFragmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HeroDetailsFragmentViewModel(favoriteHeroDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}