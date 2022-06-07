package com.dhandroid2022.projetointegrador.ui.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroDTO
import com.dhandroid2022.projetointegrador.data.repositories.HeroRepository
import kotlinx.coroutines.launch

class HeroesFragmentViewModel : ViewModel() {

    private val repository = HeroRepository()

    private var _heroesList = MutableLiveData<List<HeroDTO>>()

    val heroesList: MutableLiveData<List<HeroDTO>>
        get() = _heroesList

    init {
        getHeroes("0")
    }

    fun getHeroes(offset: String) {
        val heroList = mutableListOf<HeroDTO>()
        viewModelScope.launch {
            val tempList = repository.fetchHeroList(offset)
            for (hero in tempList.data.hero) {
                heroList.add(hero)
            }
            _heroesList.value = heroList
        }
    }

}