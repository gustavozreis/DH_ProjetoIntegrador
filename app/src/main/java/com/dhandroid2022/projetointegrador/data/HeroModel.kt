package com.dhandroid2022.projetointegrador.data

data class HeroModel(
    val charId: Int,
    val charName: String,
    val charDescription: String,
    val charComics: List<ComicModel>,
    val charThumbnail: Int
)
