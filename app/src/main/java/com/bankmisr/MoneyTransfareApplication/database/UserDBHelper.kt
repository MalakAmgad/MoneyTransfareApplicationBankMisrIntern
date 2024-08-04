package com.bankmisr.MoneyTransfareApplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bankmisr.MoneyTransfareApplication.database.user.User
import com.bankmisr.MoneyTransfareApplication.database.user.UserDAO


@Database(entities = [User::class , Transaction::class], version = 2, exportSchema = false)
abstract class UserDBHelper:RoomDatabase() {

    abstract val dao: UserDAO
    abstract val transactionDao: TransactionsDAO


    companion object{


        private var INSTANCE:UserDBHelper?=null
        fun getInstance(c: Context):UserDBHelper{
            return INSTANCE?: synchronized(this){
                var instance = Room.databaseBuilder(c,UserDBHelper::class.java,"MyDB")
                    //.fallbackToDestructiveMigration() // Add this line
                    .build()
                INSTANCE=instance
                instance
            }
        }
    }

}