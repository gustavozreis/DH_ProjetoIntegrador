package com.dhandroid2022.projetointegrador.data.dto

data class HeroDTO(
    val charId: Int,
    val charName: String,
    val charDescription: String,
    val charComicDTOS: List<ComicDTO>,
    val charThumbnail: Int
)
