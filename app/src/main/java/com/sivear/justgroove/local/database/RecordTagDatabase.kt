package com.sivear.justgroove.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sivear.justgroove.local.dao.RecordTagDao
import com.sivear.justgroove.local.entity.RecordTagEntity

@Database(entities = [RecordTagEntity::class], version = 1, exportSchema = false)
abstract class RecordTagDatabase: RoomDatabase() {
    abstract fun getRecordTagDao(): RecordTagDao

    companion object {
        @Volatile
        private var INSTANCE: RecordTagDatabase? = null

        fun getDatabase(context: Context): RecordTagDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = RecordTagDatabase::class.java,
                    name = "record_tag_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}