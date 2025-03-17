package com.sivear.justgroove.model.account

data class AccountModel(
    val id: Number,
    val name: String,
    val avatar: String,
    val title: AccountTitle
)