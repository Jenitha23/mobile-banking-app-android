package com.example.mobilebankingapp

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase

@Dao
interface TransferDao {
    @Insert
    suspend fun insert(request: TransferRequest)

    @Query("SELECT * FROM transfer_history ORDER BY id DESC")
    suspend fun getAll(): List<TransferRequest>

    @Delete
    suspend fun delete(request: TransferRequest)
}

@Database(entities = [TransferRequest::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun transferDao(): TransferDao

    companion object {
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "banking_app_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}