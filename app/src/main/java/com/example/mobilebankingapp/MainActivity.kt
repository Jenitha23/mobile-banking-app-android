package com.example.mobilebankingapp

import android.content.Context
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {

    // Challenge Exercise: reacts when SessionReminderService broadcasts that
    // the session has expired.
    private val sessionExpiredReceiver = SessionExpiredReceiver {
        Toast.makeText(
            this, "Your session has expired due to inactivity.", Toast.LENGTH_LONG
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        applySavedTheme()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load DashboardFragment on initial launch
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fragmentContainer, DashboardFragment())
                .commit()
        }
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(SessionReminderService.ACTION_SESSION_EXPIRED)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            registerReceiver(sessionExpiredReceiver, filter, Context.RECEIVER_NOT_EXPORTED)
        } else {
            registerReceiver(sessionExpiredReceiver, filter)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(sessionExpiredReceiver)
    }

    // Challenge Exercise: light/dark theme toggle, read once at startup
    // before setContentView so the correct theme applies immediately.
    private fun applySavedTheme() {
        val prefs = getSharedPreferences("banking_app_prefs", Context.MODE_PRIVATE)
        val darkModeEnabled = prefs.getBoolean("dark_mode_enabled", false)
        AppCompatDelegate.setDefaultNightMode(
            if (darkModeEnabled) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )
    }

    fun showDashboardFragment() {
        // Clear any Transfer / Confirmation / Success fragments off the back stack
        // so the system Back button from Dashboard exits the app instead of
        // re-entering a transfer that has already been completed.
        supportFragmentManager.popBackStack(null, androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainer, DashboardFragment())
            .commit()
    }

    fun showTransferFragment() {
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainer, TransferFragment())
            .addToBackStack(null)
            .commit()
    }

    fun showConfirmationFragment(request: TransferRequest) {
        val fragment = ConfirmationFragment()
        fragment.arguments = Bundle().apply {
            putParcelable(ConfirmationFragment.ARG_TRANSFER_REQUEST, request)
        }
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun showSuccessFragment(request: TransferRequest) {
        val fragment = SuccessFragment()
        fragment.arguments = Bundle().apply {
            putParcelable(SuccessFragment.ARG_TRANSFER_REQUEST, request)
        }
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun showHistoryFragment() {
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .replace(R.id.fragmentContainer, HistoryFragment())
            .addToBackStack(null)
            .commit()
    }
}