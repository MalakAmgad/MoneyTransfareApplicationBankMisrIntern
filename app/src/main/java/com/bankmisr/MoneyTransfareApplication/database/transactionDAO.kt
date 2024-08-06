package com.bankmisr.MoneyTransfareApplication.database


import android.os.Parcelable
import androidx.room.Dao
import androidx.room.*
import com.bankmisr.MoneyTransfareApplication.database.user.User
import kotlinx.coroutines.flow.Flow
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("transactions")
data class Transaction (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("_id")
    val id: Int = 0,
    @ColumnInfo("amount")
    val amount:Double,
    @ColumnInfo("sender")
    val sender: String,
    @ColumnInfo("sender_acount")
    val SenderAcount: Long,
    @ColumnInfo("receiver")
    val receiver: String,
    @ColumnInfo("receiver_acount")
    val receiverAcount: Long,
    @ColumnInfo("reference")
    val reference: Long,
    @ColumnInfo("date")
    val date: Long,
    @ColumnInfo("stauts")
    val status: Boolean
) : Parcelable

@Dao
interface TransactionsDAO {
    @Upsert
    suspend fun insertTransaction(transaction: Transaction)
    @Update
    suspend fun updateTransaction(transaction: Transaction)

    @Delete
    suspend fun deleteTransaction(transaction: Transaction)

    @Query("SELECT * FROM transactions")
    fun getAllTransactions(): Flow<List<Transaction>>

    @Query("SELECT* FROM transactions WHERE sender_acount = :account ORDER BY date DESC LIMIT 3")
    fun getuserTransaction(account: Long): Flow<List<Transaction>>

    @Query("SELECT * FROM transactions where reference =:refrence ")
    fun getTransaction(refrence:Long ): Flow<Transaction?>

}