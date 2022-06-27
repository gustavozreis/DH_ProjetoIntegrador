package com.dhandroid2022.projetointegrador.data.favorites

import androidx.lifecycle.MutableLiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteHeroDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favHero: FavoriteHero)

    @Delete
    suspend fun delete(favHero: FavoriteHero)

    @Query("DELETE FROM favorites WHERE id = :primaryId")
    suspend fun deleteHero(primaryId: Int)

    @Query("SELECT * FROM favorites")
    suspend fun getAll(): MutableList<FavoriteHero>

}