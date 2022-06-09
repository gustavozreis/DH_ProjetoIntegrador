package com.dhandroid2022.projetointegrador.ui.ViewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dhandroid2022.projetointegrador.data.heroDTO.HeroDTO
import com.dhandroid2022.projetointegrador.data.repositories.HeroRepository
import kotlinx.coroutines.launch

class HeroDetailsFragmentViewModel : ViewModel() {

    private val repository = HeroRepository()

    private var _hero = MutableLiveData<HeroDTO>()
    val hero: MutableLiveData<HeroDTO>
        get() = _hero

    fun getHeroDetails(heroID: String) {
        var hero: HeroDTO
        viewModelScope.launch {
            hero = repository.fetchHeroDetails(heroID).data
            _hero.value = hero
        }
    }

}