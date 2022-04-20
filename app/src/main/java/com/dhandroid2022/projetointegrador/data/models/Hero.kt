package com.dhandroid2022.projetointegrador.data.models

data class Hero(
    val charId: Int,
    val charName: String,
    val charDescription: String,
    val charComics: List<Comic>,
    val charThumbnail: Int
)
