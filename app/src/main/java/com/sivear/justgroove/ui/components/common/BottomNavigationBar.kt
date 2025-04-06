package com.sivear.justgroove.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.sivear.justgroove.model.bottom_bar.BottomBarItemModel

@Composable
fun BottomNavigationBar(navController: NavController) {
    val navigationList = listOf(
        BottomBarItemModel.Home,
        BottomBarItemModel.Schedule,
        BottomBarItemModel.Community,
        BottomBarItemModel.Mine
    )
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 0.dp,
        modifier = Modifier.shadow(5.dp).background(MaterialTheme.colorScheme.background),
    ) {
        navigationList.forEach {
            key(it.id) {
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = it.icon,
                            contentDescription = stringResource(it.nameResId)
                        )
                    },
                    label = {
                        Text(stringResource(it.nameResId))
                    },
                    selected = currentRoute == it.route.route,
                    onClick = {
                        navController.navigate(it.route.route)
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = MaterialTheme.colorScheme.primary,
                        selectedTextColor = MaterialTheme.colorScheme.primary,
                        unselectedIconColor = MaterialTheme.colorScheme.onBackground,
                        unselectedTextColor = MaterialTheme.colorScheme.onBackground,
                        indicatorColor = Color.Transparent, // 防止选中状态覆盖颜色

                    ),
                )
            }
        }
    }
}