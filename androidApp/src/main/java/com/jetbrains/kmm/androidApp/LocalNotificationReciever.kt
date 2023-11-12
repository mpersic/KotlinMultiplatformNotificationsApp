package com.jetbrains.kmm.androidApp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class LocalNotificationReciever : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val service = LocalNotificationService(context)
        service.showNotification(++Counter.value)
    }
}