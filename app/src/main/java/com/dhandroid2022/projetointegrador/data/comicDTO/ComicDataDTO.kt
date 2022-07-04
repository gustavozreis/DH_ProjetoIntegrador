package com.dhandroid2022.projetointegrador.data.comicDTO

import com.google.gson.annotations.SerializedName

data class ComicDataDTO(
    @SerializedName("results")
    val comicList: List<ComicDTO>,
)