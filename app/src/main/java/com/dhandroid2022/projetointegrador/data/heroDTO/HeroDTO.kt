package com.dhandroid2022.projetointegrador.data.heroDTO

import com.dhandroid2022.projetointegrador.data.comicDTO.models.ComicsList
import com.dhandroid2022.projetointegrador.data.utils.Thumbnail
import com.google.gson.annotations.SerializedName

data class HeroDTO(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
    @SerializedName("comics")
    val comicsList: ComicsList,

    )
