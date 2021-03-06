package com.dhandroid2022.projetointegrador.data.comicDTO

import com.dhandroid2022.projetointegrador.data.utils.Thumbnail

data class ComicDTO(
    val id: Int,
    val resourceURI: String,
    val title: String,
    val thumbnail: Thumbnail,
    val description: String,
)
