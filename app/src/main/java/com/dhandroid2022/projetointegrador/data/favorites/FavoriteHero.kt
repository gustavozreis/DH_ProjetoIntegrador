package com.dhandroid2022.projetointegrador.data.favorites

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites")
data class FavoriteHero(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "NOME")
    val name: String,
    @ColumnInfo(name = "THUMB_URL")
    val thumbUrl: String,
) {

}