package com.bankmisr.MoneyTransfareApplication.database.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteDao {
    @Upsert
    suspend fun upsertFavourite(n: Favourite)

    @Delete
    suspend fun deleteFavourite(n: Favourite)

    @Query("SELECT * FROM Favourite ")
    fun getAllFavourits(): Flow<List<Favourite>>


}