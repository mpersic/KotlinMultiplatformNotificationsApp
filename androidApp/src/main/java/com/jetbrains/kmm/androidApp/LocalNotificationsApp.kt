package com.jetbrains.kmm.androidApp

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class LocalNotificationsApp : Application() {
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel();
    }

    private fun createNotificationChannel() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                LocalNotificationService.LOCAL_NOTIFICATION_CHANNEL_ID,
                "LocalNotification",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "Used for local notif"
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}