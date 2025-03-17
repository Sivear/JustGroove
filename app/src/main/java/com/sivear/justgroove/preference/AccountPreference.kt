package com.sivear.justgroove.preference

import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.core.edit
import com.google.gson.Gson
import com.sivear.justgroove.model.account.AccountModel
import com.sivear.justgroove.model.account.AccountTitle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.accountDataStore by preferencesDataStore(name = PreferenceNames.AccountPreference.name)

class AccountPreference private constructor() {
    private val basicInfoKey = stringPreferencesKey("basic_info")

    suspend fun saveAccountInfo(ctx: Context, info: AccountModel) {
        ctx.accountDataStore.edit { data ->
            data[basicInfoKey] = info.toString()
        }
    }

    suspend fun getAccountInfo(ctx: Context): AccountModel {
        val dataFlow = ctx.accountDataStore.data.map { prefs ->
            prefs[basicInfoKey] ?: "" // 取出 JSON 字符串
        }
//
//        return dataFlow.first().let { json ->
//            Log.i("testtttttt", json)
//
//            Gson().fromJson(json, AccountModel::class.java) // 解析 JSON 为对象
//        }
        return AccountModel(1, "11", "1111", AccountTitle.None)
    }

    companion object {
        @Volatile
        private var INSTANCE: AccountPreference? = null

        fun getInstance(): AccountPreference {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: AccountPreference().also { INSTANCE = it }
            }
        }
    }
}
