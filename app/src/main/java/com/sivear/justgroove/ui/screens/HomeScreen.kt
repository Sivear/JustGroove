package com.sivear.justgroove.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.sivear.justgroove.ui.components.common.Header
import com.sivear.justgroove.ui.components.home.HomeBody

@Composable
fun HomeScreen() {
    Column {
        Header()
        HomeBody()
    }
}