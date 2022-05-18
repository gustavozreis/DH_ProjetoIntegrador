package com.dhandroid2022.projetointegrador.data

import com.dhandroid2022.projetointegrador.data.dto.ComicDTO
import com.dhandroid2022.projetointegrador.data.dto.HeroDTO

object HeroDBMock {

    val heroesList: MutableList<HeroDTO> = mutableListOf()

    fun createHero(charId: Int, charName: String, charDescription: String, charComicDTOS: List<ComicDTO>, charThumbnail: Int) {
        val newHeroDTO = HeroDTO(charId, charName, charDescription, charComicDTOS, charThumbnail)
        heroesList.add(newHeroDTO)
    }

}