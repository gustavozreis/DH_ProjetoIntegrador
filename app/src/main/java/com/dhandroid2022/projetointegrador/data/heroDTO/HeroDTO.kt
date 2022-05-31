package com.dhandroid2022.projetointegrador.data.heroDTO

import com.dhandroid2022.projetointegrador.data.comicDTO.ComicDTO
import com.dhandroid2022.projetointegrador.data.heroDTO.attributesmodels.Thumbnail

data class HeroDTO(
    val id: String,
    val name: String,
    val thumbnail: Thumbnail
)
