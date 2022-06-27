package com.dhandroid2022.projetointegrador.data.favorites

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoriteHero::class], version = 2, exportSchema = false)
abstract class FavoritesRoomDatabase : RoomDatabase() {

    abstract fun favoriteHeroDao(): FavoriteHeroDAO

    companion object{
        @Volatile
        private var INSTANCE: FavoritesRoomDatabase? = null

        fun getDatabase(context: Context): FavoritesRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavoritesRoomDatabase::class.java,
                    "time_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}