package com.dhandroid2022.projetointegrador.data

class HeroesBuilder {

    var heroesList = mutableListOf<Hero>()

    fun createHero(charName: String, charDescription: String, charComics: List<Comics>, charThumbnail: Int) {
        val newHeroe = Hero(charName, charDescription, charComics, charThumbnail)
        heroesList.add(newHeroe)
    }

}