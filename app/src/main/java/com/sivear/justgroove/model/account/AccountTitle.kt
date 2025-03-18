package com.sivear.justgroove.model.account

import android.graphics.Color
import com.sivear.justgroove.R
import kotlinx.serialization.Serializable

@Serializable
enum class AccountTitle(val titleResId: Int, val color: Int) {
    None(R.string.account_title_none, Color.GRAY)
}