# Mobile Banking App (Android)

A fund-transfer mobile banking app built in **Kotlin** for the **SE3092: Platform Based Development** module (BSc (Hons) in Computer Science, Faculty of Computing, SLIIT, Year 3 Semester 2, 2026).

The app was developed incrementally across the module's lab sheets (Lab 03 to Lab 08). It takes a Figma design and turns it into a working Android app with biometric login, a validated transfer form, local persistence, background services, and automated tests.

![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-7F52FF?logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-minSdk%2024-3DDC84?logo=android&logoColor=white)
![Room](https://img.shields.io/badge/Room-2.8.4-4285F4)
![Tests](https://img.shields.io/badge/tests-JUnit%20%7C%20Espresso-brightgreen)

---

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Running the Tests](#running-the-tests)
- [Lab Sheet Progress](#lab-sheet-progress)
- [Known Limitations](#known-limitations)
- [Acknowledgements](#acknowledgements)

---

## Features

- **Biometric login**: `BiometricPrompt` with `BIOMETRIC_STRONG` only. Availability is checked with `BiometricManager` first, and the app falls back to the password form when biometrics are missing, not enrolled, cancelled, or locked out.
- **Dashboard**: account balance, quick actions to transfer funds and view history, and a light/dark theme toggle saved in SharedPreferences.
- **Fund transfer form**: Data Binding based form (account, name, bank, amount, remarks) with inline `setError()` validation. The Submit button stays disabled until the required fields are filled.
- **Pure-Kotlin validation**: `TransferValidator` has no Android dependencies, so every rule is covered by fast local unit tests.
- **Confirmation and success screens**: the validated `TransferRequest` is passed between fragments through a `Bundle`.
- **Transfer history**: transfers are saved to a **Room** database and listed in a `RecyclerView`, most recent first.
- **Session reminder**: a `LifecycleService` posts a notification after a timeout, requesting `POST_NOTIFICATIONS` at runtime on Android 13+.
- **Broadcast receiver**: `SessionExpiredReceiver` lets `MainActivity` react when the session reminder fires.
- **Last-recipient pre-fill**: the most recent recipient is remembered with SharedPreferences.
- **Contacts autocomplete**: recipient name suggestions from the device contacts (`READ_CONTACTS`, requested at runtime).
- **Currency formatting**: amounts are shown as `LKR 12,500.00`.


## Tech Stack

| Area | Technology |
|---|---|
| Language | Kotlin 2.1.0 (JVM target 11) |
| UI | XML layouts, Material Components, ConstraintLayout, View Binding and Data Binding |
| Navigation | Single-activity with Fragments and `FragmentManager` transactions |
| Persistence | Room 2.8.4 (Entity, DAO, RoomDatabase) and SharedPreferences |
| Concurrency | Kotlin coroutines with `lifecycleScope` and `LifecycleService` |
| Authentication | AndroidX Biometric 1.1.0 |
| Background work | Started Service, Notifications, BroadcastReceiver |
| Testing | JUnit 4, Espresso, AndroidX Test |
| Build | Gradle (Kotlin DSL), version catalog, KSP |

**SDK levels:** `minSdk 24`, `targetSdk 36`, `compileSdk 37`.

## Architecture

The app uses a single `MainActivity` that hosts every screen as a fragment. `LoginActivity` is the launcher and gates entry to `MainActivity`.

```
LoginActivity
    |  (biometric success, or password fallback)
    v
MainActivity  -- hosts --> DashboardFragment
                              |-> TransferFragment -> ConfirmationFragment -> SuccessFragment
                              |-> HistoryFragment
```

Business logic is kept out of the UI layer where possible. `TransferValidator` is a plain Kotlin object that takes `String` arguments and returns an error message or `null`. `TransferFragment` only decides which field should display the returned error. This split is what makes the validation logic unit-testable without a device.

## Project Structure

```
.
├── app/
│   └── src/
│       ├── main/java/com/example/mobilebankingapp/
│       │   ├── LoginActivity.kt            # Biometric login + password fallback
│       │   ├── MainActivity.kt             # Fragment host, theme, receiver registration
│       │   ├── DashboardFragment.kt
│       │   ├── TransferFragment.kt         # Data-bound form, contacts autocomplete
│       │   ├── ConfirmationFragment.kt
│       │   ├── SuccessFragment.kt
│       │   ├── HistoryFragment.kt
│       │   ├── TransferHistoryAdapter.kt   # RecyclerView adapter
│       │   ├── TransferRequest.kt          # Room entity + data model
│       │   ├── TransferValidator.kt        # Pure Kotlin validation
│       │   ├── AppDatabase.kt              # Room database + DAO
│       │   ├── SessionReminderService.kt   # LifecycleService + notification
│       │   ├── Sessionexpiredreceiver.kt
│       │   └── CurrencyFormatter.kt
│       ├── main/res/                       # Layouts, drawables, themes
│       ├── test/                           # Local JUnit tests (TransferValidatorTest)
│       └── androidTest/                    # Espresso tests (TransferFlowTest)
├── gradle/
│   └── libs.versions.toml                  # Version catalog
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## Getting Started

### Prerequisites

- Android Studio (latest stable release recommended)
- JDK 11 or newer (the bundled Android Studio JDK works)
- An Android emulator or physical device running **Android 7.0 (API 24) or higher**

### Run the app

```bash
# 1. Clone the repository
git clone https://github.com/Jenitha23/mobile-banking-app-android.git
cd mobile-banking-app-android

# 2. Open the folder in Android Studio and let Gradle sync
# 3. Select a device or emulator, then click Run
```

Or from the command line:

```bash
./gradlew assembleDebug        # Windows: gradlew.bat assembleDebug
./gradlew installDebug         # install on a connected device
```

### Testing biometric login on an emulator

Most emulator images have no biometric hardware, so the app will go straight to the password form. To see the biometric prompt, use an emulator image with a virtual fingerprint sensor and enrol a fingerprint under **Extended Controls > Fingerprint**, or test on a physical device.

## Running the Tests

**Unit tests** (local JVM, no device needed):

```bash
./gradlew testDebugUnitTest
```

`TransferValidatorTest` covers each validation rule: blank account, blank name, non-numeric amount, zero amount, negative amount, and valid input.

**Instrumented tests** (needs a running emulator or device):

```bash
./gradlew connectedDebugAndroidTest
```

`TransferFlowTest` uses Espresso to open the transfer form, fill in valid data, submit, and check that the confirmation screen appears. For reliable results, turn off the window, transition, and animator duration scales under **Developer options** on the test device.

## Lab Sheet Progress

| Lab | Topic | What it added to the app |
|:---:|---|---|
| 03 | UI/UX design in Figma | Screen designs recreated as XML layouts |
| 04 | Data Binding | Data-bound transfer form, `TransferRequest`, input validation |
| 05 | Fragments, Room, RecyclerView | Single-activity fragment navigation, transfer history saved to Room |
| 06 | Services and Settings | Session reminder service, notifications, SharedPreferences, broadcast receiver |
| 07 | Biometric login | `BiometricPrompt` login with password fallback |
| 08 | Testing | `TransferValidator` extraction, JUnit unit tests, Espresso UI test |

## Known Limitations

This is a coursework project, so some parts are simplified on purpose:

- There is no real backend. Balances, accounts, and transfers are local only.
- Login is a simulated gate and does not verify real credentials.
- The 30-second session reminder stands in for a real session timeout.
- Data is stored unencrypted in the local Room database and SharedPreferences.


## Acknowledgements

- SE3092: Platform Based Development lab sheets, Faculty of Computing, SLIIT
- [Android Developers documentation](https://developer.android.com)

