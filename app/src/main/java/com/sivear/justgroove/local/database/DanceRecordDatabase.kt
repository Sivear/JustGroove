package com.sivear.justgroove.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sivear.justgroove.local.dao.DanceRecordDao
import com.sivear.justgroove.local.entity.DanceRecordEntity

@Database(entities = [DanceRecordEntity::class], version = 1, exportSchema = false)
abstract class DanceRecordDatabase : RoomDatabase() {
    abstract fun getDanceRecordDao(): DanceRecordDao

    companion object {
        @Volatile
        private var INSTANCE: DanceRecordDatabase? = null
        fun getDatabase(context: Context): DanceRecordDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DanceRecordDatabase::class.java,
                    "dance_record_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}