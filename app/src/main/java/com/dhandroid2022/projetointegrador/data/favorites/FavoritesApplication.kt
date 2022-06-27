package com.dhandroid2022.projetointegrador.data.favorites

import android.app.Application
import com.dhandroid2022.projetointegrador.data.favorites.FavoritesRoomDatabase

class FavoritesApplication : Application() {
    val database: FavoritesRoomDatabase by lazy { FavoritesRoomDatabase.getDatabase(this) }
}