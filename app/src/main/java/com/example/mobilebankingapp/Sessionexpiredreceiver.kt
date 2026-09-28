package com.example.mobilebankingapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

/**
 * Challenge Exercise: listens for the broadcast SessionReminderService sends
 * once the reminder notification fires. Registered at runtime (not in the
 * manifest) by MainActivity, since implicit broadcast receivers declared in
 * the manifest are restricted on modern Android versions.
 */
class SessionExpiredReceiver(
    private val onSessionExpired: () -> Unit
) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == SessionReminderService.ACTION_SESSION_EXPIRED) {
            onSessionExpired()
        }
    }
}