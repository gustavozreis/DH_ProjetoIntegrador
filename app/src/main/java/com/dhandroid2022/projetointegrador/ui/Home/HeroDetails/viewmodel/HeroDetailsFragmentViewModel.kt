package com.dhandroid2022.projetointegrador.ui.Home.HeroDetails.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhandroid2022.projetointegrador.data.comicDTO.ComicDTO
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroDTO
import com.dhandroid2022.projetointegrador.data.repositories.ComicRepository
import com.dhandroid2022.projetointegrador.data.repositories.HeroRepository
import kotlinx.coroutines.launch

class HeroDetailsFragmentViewModel : ViewModel() {

    private val heroRepository = HeroRepository()
    private val comicRepository = ComicRepository()

    private var _hero = MutableLiveData<HeroDTO>()
    val hero: MutableLiveData<HeroDTO>
        get() = _hero

    private var _comicList = MutableLiveData<List<ComicDTO>>(mutableListOf())
    val comicList: MutableLiveData<List<ComicDTO>>
        get() = _comicList

    private var heroIdFromArgs: String = ""

    fun getHeroDetails(heroID: String) {
        var hero: HeroDTO
        viewModelScope.launch {
            hero = heroRepository.fetchHeroDetails(heroID).data
            _hero.value = hero
        }
    }

    fun getHeroIdFromArgs(heroID: String) {
        heroIdFromArgs = heroID
        getComicList(heroID)
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

}