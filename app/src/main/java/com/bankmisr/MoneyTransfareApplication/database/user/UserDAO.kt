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

    @Query("SELECT * FROM user where email=:Email AND password=:Password ")
    fun getUser(Email:String,Password:String): Flow< User?>

    @Query("SELECT * FROM user where email=:Email ")
    fun getUserAuthentication(Email:String): Flow< User?>

    @Query("SELECT * FROM user where account_number=:account")
    fun getUserAccount(account:Long): Flow< User?>

}