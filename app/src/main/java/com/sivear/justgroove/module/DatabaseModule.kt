//package com.sivear.justgroove.module
//
//import android.content.Context
//import com.sivear.justgroove.local.dao.DanceTagDao
//import com.sivear.justgroove.local.database.DanceTagDatabase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class) // 让 Hilt 在整个 App 生命周期内可用
//object DatabaseModule {
//    @Provides
//    @Singleton
//    fun provideDanceCategoryDatabase(@ApplicationContext context: Context): DanceCategoryDatabase {
//        return DanceCategoryDatabase.getDatabase(context)
//    }
//
//    @Provides
//    fun provideDanceCategoryDao(db: DanceCategoryDatabase): DanceCategoryDao {
//        return db.getDanceCategoryDao()
//    }
//}