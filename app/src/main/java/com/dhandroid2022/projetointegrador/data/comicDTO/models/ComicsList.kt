package com.dhandroid2022.projetointegrador.data.comicDTO.models

import com.dhandroid2022.projetointegrador.data.comicDTO.Comic

data class ComicsList(
    val available: Int,
    val collectionURI: String,
    val items: List<Comic>
)