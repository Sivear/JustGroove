package com.sivear.justgroove.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sivear.justgroove.local.entity.RecordTagEntity

@Dao
interface RecordTagDao {
    @Insert
    suspend fun insert(item: RecordTagEntity)

    @Delete
    suspend fun delete(item: RecordTagEntity)

    @Query("SELECT * from record_tag where record_id = :recordId")
    suspend fun getRecordTags(recordId: Long): List<RecordTagEntity>
}