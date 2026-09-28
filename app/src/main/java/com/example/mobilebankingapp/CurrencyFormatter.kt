package com.example.mobilebankingapp

import java.text.DecimalFormat


object CurrencyFormatter {
    private val decimalFormat = DecimalFormat("#,##0.00")

    fun format(amount: Double): String = "LKR ${decimalFormat.format(amount)}"
}
