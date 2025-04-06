package com.sivear.justgroove.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sivear.justgroove.local.dao.DanceTagDao
import com.sivear.justgroove.local.entity.DanceTagEntity

@Database(entities = [DanceTagEntity::class], version = 1, exportSchema = false)
abstract class DanceTagDatabase : RoomDatabase() {
    abstract fun getDanceTagDao(): DanceTagDao

    companion object {
        @Volatile
        private var INSTANCE: DanceTagDatabase? = null

        fun getDatabase(ctx: Context): DanceTagDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context = ctx.applicationContext,
                    klass = DanceTagDatabase::class.java,
                    name = "dance_tag_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

}