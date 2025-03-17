package com.sivear.justgroove.model.bottom_bar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.sivear.justgroove.R
import com.sivear.justgroove.route.RouteTable

sealed class BottomBarItemModel(
    val id: Int,
    val nameResId: Int,
    val icon: ImageVector,
    val route: RouteTable
) {
    data object Home: BottomBarItemModel(1, R.string.bottom_bar_home, Icons.Default.Home, RouteTable.Home)
    data object Schedule: BottomBarItemModel(2, R.string.bottom_bar_schedule, Icons.Default.DateRange, RouteTable.Schedule)
    data object Community: BottomBarItemModel(3, R.string.bottom_bar_community, Icons.Default.Face, RouteTable.Community)
    data object Mine: BottomBarItemModel(4, R.string.bottom_bar_mine, Icons.Default.Person, RouteTable.Mine)
}