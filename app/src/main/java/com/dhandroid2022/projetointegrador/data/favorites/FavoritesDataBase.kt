package com.dhandroid2022.projetointegrador.data.favorites

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteHero::class], version = 1)
abstract class FavoritesDataBase : RoomDatabase() {

    abstract fun favoriteHeroDAO(): FavoriteHeroDAO
}