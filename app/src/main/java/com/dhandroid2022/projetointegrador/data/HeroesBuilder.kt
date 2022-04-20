package com.dhandroid2022.projetointegrador.data

import com.dhandroid2022.projetointegrador.data.models.Comic
import com.dhandroid2022.projetointegrador.data.models.Hero

class HeroesBuilder {

    var heroesList = mutableListOf<Hero>()

    fun createHero(charId: Int, charName: String, charDescription: String, charComics: List<Comic>, charThumbnail: Int) {
        val newHeroe = Hero(charId, charName, charDescription, charComics, charThumbnail)
        heroesList.add(newHeroe)
    }

}