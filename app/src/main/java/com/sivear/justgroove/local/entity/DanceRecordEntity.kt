package com.sivear.justgroove.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dance_record")
data class DanceRecordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "lesson_time")
    val lessonTime: Long,
    @ColumnInfo(name = "create_time")
    val createTime: Long,
    @ColumnInfo(name = "modify_time")
    var modifyTime: Long,
    @ColumnInfo(name = "category")
    var category: Int,
    @ColumnInfo(name = "teacher", defaultValue = "")
    var teacher: String,
    @ColumnInfo(name = "cover", defaultValue = "")
    var cover: String,
    @ColumnInfo(name = "description", defaultValue = "")
    var description: String,
    @ColumnInfo(name = "practice_content", defaultValue = "")
    var practiceContent: String,
    @ColumnInfo(name = "thoughts", defaultValue = "")
    var thoughts: String,
    @ColumnInfo(name = "video_uri")
    var videoUri: String
)