package com.bankmisr.MoneyTransfareApplication.ui.SignInUp.signup1

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.bankmisr.MoneyTransfareApplication.database.Transaction
import com.bankmisr.MoneyTransfareApplication.database.user.User
import com.bankmisr.MoneyTransfareApplication.database.UserDBHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(app: Application): AndroidViewModel(app) {



    private val _selectedIndex = mutableStateOf<Int?>(null)
    var selectedIndex: MutableState<Int?> = _selectedIndex

    fun updateSelectedIndex(index: Int?) {
        _selectedIndex.value = index
    }
    private val db= UserDBHelper.getInstance(app)
    fun upsert(n: User){
        viewModelScope.launch(Dispatchers.IO){ db.dao.upsertUser(n)}
    }
    fun delete(n: User){
        viewModelScope.launch(Dispatchers.IO) { db.dao.deleteUser(n) }
    }


    fun getLastUser() = db.dao.getLastUser()


    fun getUsers()=db.dao.getAllUsers()

    fun insertTransaction(n: Transaction) {
        viewModelScope.launch(Dispatchers.IO) { db.transactionDao.insertTransaction(n) }
    }

    fun deleteTransaction(n: Transaction) {
        viewModelScope.launch(Dispatchers.IO) { db.transactionDao.deleteTransaction(n) }
    }
    fun getAllTransactions() = db.transactionDao.getAllTransactions()


}