package com.dhandroid2022.projetointegrador.ui.Home.HeroList.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroDTO
import com.dhandroid2022.projetointegrador.data.repositories.HeroRepository
import com.dhandroid2022.projetointegrador.data.utils.ApiResult
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

    var isLoading = MutableLiveData<Boolean>(false)

    init {
        instantiateHeroList()
    }

    fun getHeroes() {
        val totalHeroList: MutableList<HeroDTO> = mutableListOf()
        val returnedHeroes = mutableListOf<HeroDTO>()
        val tempOffset = offset.value
        offset.value = tempOffset!! + 100
        totalHeroList.addAll(heroesList.value!!)

        try {
            viewModelScope.launch {
                isLoading.value = true
                val apiResponse = repository.fetchHeroList(tempOffset.toString())

                if (apiResponse is ApiResult.Success) {
                    val tempList = apiResponse.data.data.heroList
                    for (hero in tempList) {
                        totalHeroList.add(hero)
                        returnedHeroes.add(hero)
                    }
                    _heroesList.value = totalHeroList
                    _heroesToAdd.value = returnedHeroes
                    isLoading.value = false
                } else {
                    _heroesList.value = totalHeroList
                    //_heroesToAdd.value = returnedHeroes
                }
            }
        } catch (e: Exception) {
            Log.e("ERRO", e.printStackTrace().toString())
        }

    }

    private fun instantiateHeroList() {
        val heroList: MutableList<HeroDTO> = mutableListOf()

        try {
            viewModelScope.launch {
                val apiResponse = repository.fetchHeroList("0")

                if (apiResponse is ApiResult.Success) {
                    val tempList = apiResponse.data.data.heroList
                    for (hero in tempList) {
                        heroList.add(hero)
                    }
                    _heroesList.value = heroList
                    _heroesToAdd.value = heroList
                    offset.value = _heroesList.value!!.size
                } else {
                    _heroesList.value = heroList
                }
            }
        } catch (e: Exception) {
            Log.e("ERRO", e.printStackTrace().toString())
        }

    }

}