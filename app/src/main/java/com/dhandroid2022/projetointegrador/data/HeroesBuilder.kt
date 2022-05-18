package com.dhandroid2022.projetointegrador.data

import com.dhandroid2022.projetointegrador.data.dto.ComicDTO
import com.dhandroid2022.projetointegrador.data.dto.HeroDTO

class HeroesBuilder {

    var heroesList = mutableListOf<HeroDTO>()

    fun createHero(charId: Int, charName: String, charDescription: String, charComicDTOS: List<ComicDTO>, charThumbnail: Int) {
        val newHeroe = HeroDTO(charId, charName, charDescription, charComicDTOS, charThumbnail)
        heroesList.add(newHeroe)
    }

}