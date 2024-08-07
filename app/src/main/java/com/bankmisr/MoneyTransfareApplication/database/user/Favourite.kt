package com.bankmisr.MoneyTransfareApplication.database.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Favourite")
data class Favourite (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("_id")
    val id:Int=0 ,
    @ColumnInfo("full_name")
    val fullName :String,
    @ColumnInfo("account_number")
    val accountNumber :Long,


    ){


}