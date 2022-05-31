package com.dhandroid2022.projetointegrador.data.heroDTO

import com.google.gson.annotations.SerializedName

data class DataDTO (
    @SerializedName("results")
    val hero: List<HeroDTO>,
)