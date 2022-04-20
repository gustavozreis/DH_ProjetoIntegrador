package com.dhandroid2022.projetointegrador.data

class HeroesBuilder {

    var heroesList = mutableListOf<HeroModel>()

    fun createHero(charId: Int, charName: String, charDescription: String, charComics: List<ComicModel>, charThumbnail: Int) {
        val newHeroe = HeroModel(charId, charName, charDescription, charComics, charThumbnail)
        heroesList.add(newHeroe)
    }

}