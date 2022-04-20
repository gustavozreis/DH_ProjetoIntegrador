package com.dhandroid2022.projetointegrador.data

import com.dhandroid2022.projetointegrador.data.models.Comic
import com.dhandroid2022.projetointegrador.data.models.Hero

object HeroDBMock {

    val heroesList: MutableList<Hero> = mutableListOf()

    fun createHero(charId: Int, charName: String, charDescription: String, charComics: List<Comic>, charThumbnail: Int) {
        val newHero = Hero(charId, charName, charDescription, charComics, charThumbnail)
        heroesList.add(newHero)
    }

}