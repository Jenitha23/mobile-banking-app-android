package com.example.mobilebankingapp

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment

class DashboardFragment : Fragment() {

    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            if (granted) startSessionReminder()
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnGoToTransfer).setOnClickListener {
            (requireActivity() as MainActivity).showTransferFragment()
        }

        view.findViewById<Button>(R.id.btnGoToHistory).setOnClickListener {
            (requireActivity() as MainActivity).showHistoryFragment()
        }

        // Challenge Exercise: tapping the Profile nav item toggles dark/light theme.
        view.findViewById<View>(R.id.navProfile)?.setOnClickListener {
            toggleDarkMode()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            notificationPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        } else {
            startSessionReminder()
        }
    }

    private fun startSessionReminder() {
        requireContext().startService(
            Intent(requireContext(), SessionReminderService::class.java)
        )
    }

    private fun toggleDarkMode() {
        val prefs = requireContext().getSharedPreferences(
            "banking_app_prefs", Context.MODE_PRIVATE
        )
        val currentlyDark = prefs.getBoolean("dark_mode_enabled", false)
        val newValue = !currentlyDark

        prefs.edit().putBoolean("dark_mode_enabled", newValue).apply()

        AppCompatDelegate.setDefaultNightMode(
            if (newValue) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        )

        Toast.makeText(
            requireContext(),
            if (newValue) "Dark mode enabled" else "Light mode enabled",
            Toast.LENGTH_SHORT
        ).show()

        requireActivity().recreate()
    }
}