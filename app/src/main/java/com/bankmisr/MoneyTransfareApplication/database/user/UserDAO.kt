package com.bankmisr.MoneyTransfareApplication.database.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    @Upsert
    suspend fun upsertUser(n: User)

    @Delete
    suspend fun deleteUser(n: User)

    @Query("SELECT * FROM user ORDER BY _id DESC LIMIT 1")
    fun getLastUser(): User?

    @Query("SELECT * FROM user")
    fun getAllUsers(): Flow<List<User>>

}