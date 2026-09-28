package com.example.mobilebankingapp

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SessionReminderService : LifecycleService() {

    companion object {
        const val CHANNEL_ID = "session_reminder_channel"
        const val NOTIFICATION_ID = 1001

        const val ACTION_CANCEL_REMINDER = "com.example.mobilebankingapp.ACTION_CANCEL_REMINDER"
        const val ACTION_SESSION_EXPIRED = "com.example.mobilebankingapp.SESSION_EXPIRED"
    }

    private var reminderJob: Job? = null

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        if (intent?.action == ACTION_CANCEL_REMINDER) {
            // User tapped the Cancel action on the notification itself.
            reminderJob?.cancel()
            NotificationManagerCompat.from(this).cancel(NOTIFICATION_ID)
            stopSelf()
            return START_NOT_STICKY
        }

        reminderJob = lifecycleScope.launch {
            delay(30_000)
            postReminderNotification()
            sendSessionExpiredBroadcast()
            stopSelf()
        }
        return START_NOT_STICKY
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID, "Session Reminders",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "Warns you before your banking session times out"
            }
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }

    private fun postReminderNotification() {
        // PendingIntent that re-starts this same service with the cancel action,
        // handled above in onStartCommand.
        val cancelIntent = Intent(this, SessionReminderService::class.java).apply {
            action = ACTION_CANCEL_REMINDER
        }
        val cancelPendingIntent = PendingIntent.getService(
            this, 0, cancelIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Session expiring soon")
            .setContentText("You will be signed out soon due to inactivity.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(
                NotificationCompat.Action.Builder(
                    android.R.drawable.ic_menu_close_clear_cancel,
                    "Cancel",
                    cancelPendingIntent
                ).build()
            )
            .build()

        val hasPermission = ActivityCompat.checkSelfPermission(
            this, Manifest.permission.POST_NOTIFICATIONS
        ) == PackageManager.PERMISSION_GRANTED

        if (hasPermission) {
            NotificationManagerCompat.from(this).notify(NOTIFICATION_ID, notification)
        }
    }

    private fun sendSessionExpiredBroadcast() {
        val intent = Intent(ACTION_SESSION_EXPIRED).apply {
            setPackage(packageName) // keep it internal to this app
        }
        sendBroadcast(intent)
    }
}