package com.example.mobilebankingapp

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "transfer_history")
data class TransferRequest(
    val recipientAccount: String,
    val recipientName: String,
    val amount: Double,
    val remarks: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0
) : Parcelable