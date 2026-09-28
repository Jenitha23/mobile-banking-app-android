package com.example.mobilebankingapp

import androidx.room.InvalidationTracker
import androidx.room.RoomOpenDelegate
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.room.util.TableInfo
import androidx.room.util.TableInfo.Companion.read
import androidx.room.util.dropFtsSyncTriggers
import androidx.sqlite.SQLiteConnection
import androidx.sqlite.execSQL
import javax.`annotation`.processing.Generated
import kotlin.Lazy
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.MutableSet
import kotlin.collections.Set
import kotlin.collections.mutableListOf
import kotlin.collections.mutableMapOf
import kotlin.collections.mutableSetOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class AppDatabase_Impl : AppDatabase() {
  private val _transferDao: Lazy<TransferDao> = lazy {
    TransferDao_Impl(this)
  }

  protected override fun createOpenDelegate(): RoomOpenDelegate {
    val _openDelegate: RoomOpenDelegate = object : RoomOpenDelegate(1, "c6c921c7e3173e4c30ba14c9c88808a6", "72aa2c52e7d3ed7e42ac90ac15386a6d") {
      public override fun createAllTables(connection: SQLiteConnection) {
        connection.execSQL("CREATE TABLE IF NOT EXISTS `transfer_history` (`recipientAccount` TEXT NOT NULL, `recipientName` TEXT NOT NULL, `amount` REAL NOT NULL, `remarks` TEXT NOT NULL, `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)")
        connection.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)")
        connection.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'c6c921c7e3173e4c30ba14c9c88808a6')")
      }

      public override fun dropAllTables(connection: SQLiteConnection) {
        connection.execSQL("DROP TABLE IF EXISTS `transfer_history`")
      }

      public override fun onCreate(connection: SQLiteConnection) {
      }

      public override fun onOpen(connection: SQLiteConnection) {
        internalInitInvalidationTracker(connection)
      }

      public override fun onPreMigrate(connection: SQLiteConnection) {
        dropFtsSyncTriggers(connection)
      }

      public override fun onPostMigrate(connection: SQLiteConnection) {
      }

      public override fun onValidateSchema(connection: SQLiteConnection): RoomOpenDelegate.ValidationResult {
        val _columnsTransferHistory: MutableMap<String, TableInfo.Column> = mutableMapOf()
        _columnsTransferHistory.put("recipientAccount", TableInfo.Column("recipientAccount", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsTransferHistory.put("recipientName", TableInfo.Column("recipientName", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsTransferHistory.put("amount", TableInfo.Column("amount", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsTransferHistory.put("remarks", TableInfo.Column("remarks", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY))
        _columnsTransferHistory.put("id", TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY))
        val _foreignKeysTransferHistory: MutableSet<TableInfo.ForeignKey> = mutableSetOf()
        val _indicesTransferHistory: MutableSet<TableInfo.Index> = mutableSetOf()
        val _infoTransferHistory: TableInfo = TableInfo("transfer_history", _columnsTransferHistory, _foreignKeysTransferHistory, _indicesTransferHistory)
        val _existingTransferHistory: TableInfo = read(connection, "transfer_history")
        if (!_infoTransferHistory.equals(_existingTransferHistory)) {
          return RoomOpenDelegate.ValidationResult(false, """
              |transfer_history(com.example.mobilebankingapp.TransferRequest).
              | Expected:
              |""".trimMargin() + _infoTransferHistory + """
              |
              | Found:
              |""".trimMargin() + _existingTransferHistory)
        }
        return RoomOpenDelegate.ValidationResult(true, null)
      }
    }
    return _openDelegate
  }

  protected override fun createInvalidationTracker(): InvalidationTracker {
    val _shadowTablesMap: MutableMap<String, String> = mutableMapOf()
    val _viewTables: MutableMap<String, Set<String>> = mutableMapOf()
    return InvalidationTracker(this, _shadowTablesMap, _viewTables, "transfer_history")
  }

  public override fun clearAllTables() {
    super.performClear(false, "transfer_history")
  }

  protected override fun getRequiredTypeConverterClasses(): Map<KClass<*>, List<KClass<*>>> {
    val _typeConvertersMap: MutableMap<KClass<*>, List<KClass<*>>> = mutableMapOf()
    _typeConvertersMap.put(TransferDao::class, TransferDao_Impl.getRequiredConverters())
    return _typeConvertersMap
  }

  public override fun getRequiredAutoMigrationSpecClasses(): Set<KClass<out AutoMigrationSpec>> {
    val _autoMigrationSpecsSet: MutableSet<KClass<out AutoMigrationSpec>> = mutableSetOf()
    return _autoMigrationSpecsSet
  }

  public override fun createAutoMigrations(autoMigrationSpecs: Map<KClass<out AutoMigrationSpec>, AutoMigrationSpec>): List<Migration> {
    val _autoMigrations: MutableList<Migration> = mutableListOf()
    return _autoMigrations
  }

  public override fun transferDao(): TransferDao = _transferDao.value
}
