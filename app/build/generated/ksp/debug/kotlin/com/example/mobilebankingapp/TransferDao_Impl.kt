package com.example.mobilebankingapp

import androidx.room.EntityDeleteOrUpdateAdapter
import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import javax.`annotation`.processing.Generated
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class TransferDao_Impl(
  __db: RoomDatabase,
) : TransferDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfTransferRequest: EntityInsertAdapter<TransferRequest>

  private val __deleteAdapterOfTransferRequest: EntityDeleteOrUpdateAdapter<TransferRequest>
  init {
    this.__db = __db
    this.__insertAdapterOfTransferRequest = object : EntityInsertAdapter<TransferRequest>() {
      protected override fun createQuery(): String = "INSERT OR ABORT INTO `transfer_history` (`recipientAccount`,`recipientName`,`amount`,`remarks`,`id`) VALUES (?,?,?,?,nullif(?, 0))"

      protected override fun bind(statement: SQLiteStatement, entity: TransferRequest) {
        statement.bindText(1, entity.recipientAccount)
        statement.bindText(2, entity.recipientName)
        statement.bindDouble(3, entity.amount)
        statement.bindText(4, entity.remarks)
        statement.bindLong(5, entity.id.toLong())
      }
    }
    this.__deleteAdapterOfTransferRequest = object : EntityDeleteOrUpdateAdapter<TransferRequest>() {
      protected override fun createQuery(): String = "DELETE FROM `transfer_history` WHERE `id` = ?"

      protected override fun bind(statement: SQLiteStatement, entity: TransferRequest) {
        statement.bindLong(1, entity.id.toLong())
      }
    }
  }

  public override suspend fun insert(request: TransferRequest): Unit = performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfTransferRequest.insert(_connection, request)
  }

  public override suspend fun delete(request: TransferRequest): Unit = performSuspending(__db, false, true) { _connection ->
    __deleteAdapterOfTransferRequest.handle(_connection, request)
  }

  public override suspend fun getAll(): List<TransferRequest> {
    val _sql: String = "SELECT * FROM transfer_history ORDER BY id DESC"
    return performSuspending(__db, true, false) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _columnIndexOfRecipientAccount: Int = getColumnIndexOrThrow(_stmt, "recipientAccount")
        val _columnIndexOfRecipientName: Int = getColumnIndexOrThrow(_stmt, "recipientName")
        val _columnIndexOfAmount: Int = getColumnIndexOrThrow(_stmt, "amount")
        val _columnIndexOfRemarks: Int = getColumnIndexOrThrow(_stmt, "remarks")
        val _columnIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _result: MutableList<TransferRequest> = mutableListOf()
        while (_stmt.step()) {
          val _item: TransferRequest
          val _tmpRecipientAccount: String
          _tmpRecipientAccount = _stmt.getText(_columnIndexOfRecipientAccount)
          val _tmpRecipientName: String
          _tmpRecipientName = _stmt.getText(_columnIndexOfRecipientName)
          val _tmpAmount: Double
          _tmpAmount = _stmt.getDouble(_columnIndexOfAmount)
          val _tmpRemarks: String
          _tmpRemarks = _stmt.getText(_columnIndexOfRemarks)
          val _tmpId: Int
          _tmpId = _stmt.getLong(_columnIndexOfId).toInt()
          _item = TransferRequest(_tmpRecipientAccount,_tmpRecipientName,_tmpAmount,_tmpRemarks,_tmpId)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
