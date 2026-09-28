package com.example.mobilebankingapp

/**
 * Pure Kotlin validation for the transfer form.
 * No Fragment, no View Binding, no Context: that is what lets
 * TransferValidatorTest run on the plain JVM in milliseconds.
 */
object TransferValidator {

    const val MAX_TRANSFER_AMOUNT = 500_000.0

    /**
     * Turns what the user typed ("LKR 1,500.00", "2500", "abc") into a number,
     * or null if it is not a number. Same cleanup TransferFragment did inline before.
     */
    fun parseAmount(amountText: String): Double? =
        amountText
            .replace("LKR", "", ignoreCase = true)
            .replace(",", "")
            .trim()
            .toDoubleOrNull()

    /**
     * Returns null if the input is valid, or an error message naming
     * the first problem found, in the same order onSubmitTransfer()
     * checked them.
     */
    fun validate(
        account: String,
        name: String,
        amountText: String
    ): String? {
        if (account.isBlank()) {
            return "Enter a recipient account number"
        }
        if (name.isBlank()) {
            return "Enter a recipient name"
        }
        val amount = parseAmount(amountText)
        if (amount == null || amount <= 0.0) {
            return "Enter a valid amount greater than 0"
        }
        if (amount > MAX_TRANSFER_AMOUNT) {
            return "Amount exceeds the maximum transfer limit of " +
                CurrencyFormatter.format(MAX_TRANSFER_AMOUNT)
        }
        return null
    }
}
