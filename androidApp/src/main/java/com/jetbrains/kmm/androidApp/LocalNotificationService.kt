package com.jetbrains.kmm.androidApp

import android.app.Notification
import android.app.Notification.BigTextStyle
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.jetbrains.androidApp.R

class LocalNotificationService(
    private val context: Context
) {

    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(counter: Int){
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val incrementIntent = PendingIntent.getBroadcast(
            context,
            2,
            Intent(context, LocalNotificationReciever::class.java),
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) PendingIntent.FLAG_IMMUTABLE else 0
        )
        val notification = NotificationCompat.Builder(context, LOCAL_NOTIFICATION_CHANNEL_ID)
            .setSmallIcon(R.drawable.baseline_notifications_active_24)
            .setContentTitle("Local notification")
            .setContentText("The count is $counter")
            .setContentIntent(activityPendingIntent)
            .addAction(
                R.drawable.baseline_notifications_active_24,
                "Increment",
                incrementIntent
            )
            .build()
        notificationManager.notify(1, notification)
    }
    companion object{
        const val LOCAL_NOTIFICATION_CHANNEL_ID = "local_notification_channel"
    }
}