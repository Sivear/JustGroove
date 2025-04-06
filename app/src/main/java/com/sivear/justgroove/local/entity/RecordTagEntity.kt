package com.sivear.justgroove.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "record_tag")
data class RecordTagEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "record_id")
    val recordId: Long,
    @ColumnInfo(name = "tag_id")
    val tagId: Int
)