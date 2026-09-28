package com.example.mobilebankingapp

import android.Manifest
import android.os.Build
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.isPlatformPopup
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.GrantPermissionRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class TransferFlowTest {

    // Runs first (order = 0): pre-grants the runtime permissions this app asks for
    // (contacts on the Transfer form, notifications on the Dashboard) so the system
    // permission dialogs never appear. Espresso cannot click system dialogs.
    @get:Rule(order = 0)
    val permissionRule: GrantPermissionRule =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            GrantPermissionRule.grant(
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.POST_NOTIFICATIONS
            )
        } else {
            GrantPermissionRule.grant(Manifest.permission.READ_CONTACTS)
        }

    // Launches MainActivity directly, which skips the biometric LoginActivity.
    @get:Rule(order = 1)
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun validTransferShowsConfirmationScreen() {
        onView(withId(R.id.btnGoToTransfer)).perform(click())

        // clearText() first: the form pre-fills the last recipient from SharedPreferences.
        onView(withId(R.id.etRecipientAccount))
            .perform(clearText(), typeText("8001234567"), closeSoftKeyboard())
        onView(withId(R.id.etRecipientName))
            .perform(clearText(), typeText("Kasun Silva"), closeSoftKeyboard())

        // The bank is a required dropdown: open it, then pick from the popup window.
        onView(withId(R.id.etBank)).perform(scrollTo(), click())
        onView(withText("Sampath Bank")).inRoot(isPlatformPopup()).perform(click())

        onView(withId(R.id.etAmount))
            .perform(scrollTo(), typeText("2500"), closeSoftKeyboard())

        onView(withId(R.id.btnSubmit)).perform(scrollTo(), click())

        onView(withId(R.id.tvConfirmRecipient)).check(matches(isDisplayed()))
        onView(withId(R.id.tvConfirmAmount)).check(matches(isDisplayed()))
    }
}
