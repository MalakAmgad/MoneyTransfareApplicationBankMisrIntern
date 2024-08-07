package com.bankmisr.MoneyTransfareApplication.ui.main

import android.app.Application
import android.os.Handler
import android.os.Looper
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel


class IdleViewModel (application: Application) : AndroidViewModel(application) {
    private val handler = Handler(Looper.getMainLooper())
    private val idleRunnable = Runnable {
        isIdle.value = true
    }
    val isIdle = mutableStateOf(false)

    fun resetIdleTimer() {
        handler.removeCallbacks(idleRunnable)
        handler.postDelayed(idleRunnable, IDLE_TIMEOUT)
        isIdle.value = false
    }

    override fun onCleared() {
        super.onCleared()
        handler.removeCallbacks(idleRunnable)
    }

    companion object {
        private const val IDLE_TIMEOUT =  10 * 60 * 1000L // 30 minutes
    }
}