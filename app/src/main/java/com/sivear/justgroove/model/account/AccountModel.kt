package com.sivear.justgroove.model.account

import kotlinx.serialization.Serializable

@Serializable
data class AccountModel(
    val id: String,
    val name: String,
    val avatar: String,
    val title: AccountTitle
) {
    companion object {
        val DEFAULT = AccountModel("", "", "", AccountTitle.None)
    }
}