package com.dhandroid2022.projetointegrador.ui.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroDTO
import com.dhandroid2022.projetointegrador.data.repositories.HeroRepository
import com.dhandroid2022.projetointegrador.ui.Adapter.HeroesListAdapter
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HeroesListFragmentViewModel : ViewModel() {

    private val repository = HeroRepository()

    private var _heroesToAdd = MutableLiveData<List<HeroDTO>>()
    val heroesToAdd: MutableLiveData<List<HeroDTO>>
        get() = _heroesToAdd

    private var _heroesList = MutableLiveData<List<HeroDTO>>()
    val heroesList: MutableLiveData<List<HeroDTO>>
        get() = _heroesList

    var offset = MutableLiveData<Int>(0)

    var loadingCheck = MutableLiveData<Boolean>(false)


    init {
        instatiateHeroList()
    }

    fun getHeroes() {
        val totalHeroList: MutableList<HeroDTO> = mutableListOf()
        val returnedHeroes = mutableListOf<HeroDTO>()
        val tempOffset = offset.value
        offset.value = tempOffset!! + 100
        totalHeroList.addAll(heroesList.value!!)
        try {
            viewModelScope.launch {
                val tempList = repository.fetchHeroList(tempOffset.toString())
                for (hero in tempList.data.hero) {
                    totalHeroList.add(hero)
                    returnedHeroes.add(hero)
                }
                _heroesList.value = totalHeroList
                _heroesToAdd.value = returnedHeroes
            }

        } catch (e: Exception) {

        }

    }

    private fun instatiateHeroList() {
        val heroList: MutableList<HeroDTO> = mutableListOf()
        viewModelScope.launch {
            val tempList = repository.fetchHeroList("0")
            for (hero in tempList.data.hero) {
                heroList.add(hero)
            }
            _heroesList.value = heroList
            _heroesToAdd.value = heroList
            offset.value = _heroesList.value!!.size
        }
    }

}