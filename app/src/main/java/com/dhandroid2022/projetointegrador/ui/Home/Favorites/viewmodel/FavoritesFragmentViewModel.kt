package com.dhandroid2022.projetointegrador.ui.Home.Favorites.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.dhandroid2022.projetointegrador.data.favorites.FavoriteHero
import com.dhandroid2022.projetointegrador.data.favorites.FavoriteHeroDAO
import kotlinx.coroutines.launch

class FavoritesFragmentViewModel(private val favoriteHeroDAO: FavoriteHeroDAO) : ViewModel() {

    private var _favoritesList = MutableLiveData<MutableList<FavoriteHero>>(mutableListOf())
    val favoritesList: MutableLiveData<MutableList<FavoriteHero>>
        get() = _favoritesList

    init {
        getFavoritesList()
    }

    fun getFavoritesList() {
        viewModelScope.launch {
            val tempList = favoriteHeroDAO.getAll()
            _favoritesList.value = tempList
        }
    }
}

class FavoritesFragmentViewModelFactory(private val favoriteHeroDao: FavoriteHeroDAO) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavoritesFragmentViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FavoritesFragmentViewModel(favoriteHeroDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}