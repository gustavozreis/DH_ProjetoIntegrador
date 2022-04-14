package com.dhandroid2022.projetointegrador.data

data class Hero(
    val charName: String,
    val charDescription: String,
    val charComics: List<Comics>,
    val charThumbnail: Int
)
