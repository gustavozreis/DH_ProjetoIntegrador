package com.dhandroid2022.projetointegrador.data.comicDTO.models

import com.dhandroid2022.projetointegrador.data.comicDTO.ComicDTO

data class ComicsList(
    val available: Int,
    val collectionURI: String,
    val items: List<ComicDTO>
)