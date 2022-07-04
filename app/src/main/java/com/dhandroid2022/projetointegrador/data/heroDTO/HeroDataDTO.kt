package com.dhandroid2022.projetointegrador.data.heroDTO

import com.google.gson.annotations.SerializedName

data class HeroDataDTO (
    @SerializedName("results")
    val heroList: List<HeroDTO>,
)