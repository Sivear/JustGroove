package com.sivear.justgroove.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sivear.justgroove.local.entity.DanceTagEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DanceTagDao {
    @Insert
    suspend fun insert(tag: DanceTagEntity)

    @Delete
    suspend fun delete(tag: DanceTagEntity)

    @Query("SELECT * from dance_tag WHERE id = :id")
    fun getItem(id: Int): Flow<DanceTagEntity>

    @Query("SELECT * from dance_tag")
    fun getAllItems(): Flow<List<DanceTagEntity>>
}