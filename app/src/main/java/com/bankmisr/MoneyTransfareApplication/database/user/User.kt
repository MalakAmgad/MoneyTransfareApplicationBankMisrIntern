package com.bankmisr.MoneyTransfareApplication.database.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("user")
class User (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("_id")
    val id:Int=0 ,
    @ColumnInfo("full_name")
    val fullName :String,
    @ColumnInfo("email")
    val email :String,
    @ColumnInfo("Password")
    val password :String,
    @ColumnInfo("DateofBirth")
    val DateofBirth :String,
    @ColumnInfo("Balance")
    val Balance :Double=0.0,
    @ColumnInfo("account_number")
    val accountNumber :Long,
) {

}