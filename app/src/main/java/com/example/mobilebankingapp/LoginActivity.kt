package com.example.mobilebankingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat

/**
 * Lab 07: Biometric Login.
 *
 * LoginActivity is now the launcher activity. It gates entry to MainActivity the
 * same way the app already gates entry to a real "signed in" state elsewhere:
 * check biometric availability first, only ever show BiometricPrompt when the
 * device supports BIOMETRIC_STRONG, and fall back to the existing password form
 * (unused since Lab 3) for every other outcome.
 */
class LoginActivity : AppCompatActivity() {

    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = BiometricPrompt(
            this, executor,
            object : BiometricPrompt.AuthenticationCallback() {

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult
                ) {
                    super.onAuthenticationSucceeded(result)
                    startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    finish()
                }

                override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    // Dialog is closing for good here: negative button, cancel, or a
                    // lockout (temporary or permanent) all end up in this callback,
                    // so this is the single place the password fallback belongs.
                    Toast.makeText(this@LoginActivity, errString, Toast.LENGTH_SHORT).show()
                    showPasswordForm()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    // A single misread attempt only. The dialog stays open so the
                    // user can try again, so we must not fall back here.
                    Toast.makeText(
                        this@LoginActivity,
                        "Fingerprint not recognized, try again.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Sign in to Banking App")
            .setSubtitle("Use your fingerprint or face to continue")
            .setNegativeButtonText("Use password instead")
            .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG)
            .build()

        if (canUseBiometrics()) {
            biometricPrompt.authenticate(promptInfo)
        } else {
            showPasswordForm()
        }
    }

    /**
     * Checks device biometric availability before ever showing biometric UI.
     * Only BIOMETRIC_STRONG (Class 3) is accepted, since this is a banking app
     * gating account access, not a phone-unlock convenience feature.
     */
    private fun canUseBiometrics(): Boolean {
        val biometricManager = BiometricManager.from(this)
        val result = biometricManager.canAuthenticate(
            BiometricManager.Authenticators.BIOMETRIC_STRONG
        )
        return result == BiometricManager.BIOMETRIC_SUCCESS
    }

    /** Reveals the password fields from Lab 3's static layout, unused until now. */
    private fun showPasswordForm() {
        findViewById<View>(R.id.passwordFormGroup).visibility = View.VISIBLE
        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}
