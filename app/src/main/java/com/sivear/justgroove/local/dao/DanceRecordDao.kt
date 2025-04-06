package com.sivear.justgroove.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sivear.justgroove.local.entity.DanceRecordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DanceRecordDao {
    @Insert
    suspend fun insert(vararg records: DanceRecordEntity)

    @Update
    suspend fun update(record: DanceRecordEntity)

    @Delete
    suspend fun delete(record: DanceRecordEntity)

    @Query("SELECT * from dance_record WHERE id = :id")
    fun getItem(id: Int): Flow<DanceRecordEntity>

    @Query("SELECT * from dance_record")
    fun getAllItems(): Flow<List<DanceRecordEntity>>
}