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
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

private val Context.accountDataStore by preferencesDataStore(name = PreferenceNames.AccountPreference.name)

class AccountPreference private constructor() {
    private val basicInfoKey = stringPreferencesKey("basic_info")

    suspend fun saveAccountInfo(ctx: Context, info: AccountModel) {
        ctx.accountDataStore.edit { data ->
            data[basicInfoKey] = Json.encodeToString(info)
        }
    }

    fun getAccountInfo(ctx: Context): Flow<AccountModel> {
        return ctx.accountDataStore.data.map { prefs ->
            prefs[basicInfoKey]?.let { json ->
                Json.decodeFromString<AccountModel>(json)
            } ?: AccountModel.DEFAULT
        }
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
