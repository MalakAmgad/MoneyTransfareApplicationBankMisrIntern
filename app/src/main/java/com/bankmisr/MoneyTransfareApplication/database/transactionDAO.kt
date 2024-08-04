package com.bankmisr.MoneyTransfareApplication.database


import android.os.Parcelable
import androidx.room.Dao
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("transactions")
data class Transaction (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("_id")
    val id: Int = 0,
    @ColumnInfo("amount")
    val amount:Float,
    @ColumnInfo("sender")
    val sender: String,
    @ColumnInfo("sender_acount")
    val SenderAcount: String,
    @ColumnInfo("receiver")
    val receiver: String,
    @ColumnInfo("receiver_acount")
    val receiverAcount: String,
    @ColumnInfo("reference")
    val reference: String,
    @ColumnInfo("date")
    val date: Long,
    @ColumnInfo("stauts")
    val status: String
) : Parcelable

@Dao
interface TransactionsDAO {
    @Insert
    suspend fun insertTransaction(transaction: Transaction)
    @Update
    suspend fun updateTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    @Query("SELECT * FROM transactions")
    fun getAllTransactions(): Flow<List<Transaction>>

}