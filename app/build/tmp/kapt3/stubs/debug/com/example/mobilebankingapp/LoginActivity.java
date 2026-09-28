package com.example.mobilebankingapp;

/**
 * Lab 07: Biometric Login.
 *
 * LoginActivity is now the launcher activity. It gates entry to MainActivity the
 * same way the app already gates entry to a real "signed in" state elsewhere:
 * check biometric availability first, only ever show BiometricPrompt when the
 * device supports BIOMETRIC_STRONG, and fall back to the existing password form
 * (unused since Lab 3) for every other outcome.
 */
@kotlin.Metadata(mv = {2, 2, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/example/mobilebankingapp/LoginActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "biometricPrompt", "Landroidx/biometric/BiometricPrompt;", "promptInfo", "Landroidx/biometric/BiometricPrompt$PromptInfo;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "canUseBiometrics", "", "showPasswordForm", "app_debug"})
public final class LoginActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.biometric.BiometricPrompt biometricPrompt;
    private androidx.biometric.BiometricPrompt.PromptInfo promptInfo;
    
    public LoginActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Checks device biometric availability before ever showing biometric UI.
     * Only BIOMETRIC_STRONG (Class 3) is accepted, since this is a banking app
     * gating account access, not a phone-unlock convenience feature.
     */
    private final boolean canUseBiometrics() {
        return false;
    }
    
    /**
     * Reveals the password fields from Lab 3's static layout, unused until now.
     */
    private final void showPasswordForm() {
    }
}