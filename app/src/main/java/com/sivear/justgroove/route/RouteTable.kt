package com.sivear.justgroove.route

sealed class RouteTable(val route: String) {
    data object Home : RouteTable("home")
    data object Schedule : RouteTable("schedule")
    data object Community : RouteTable("community")
    data object Mine : RouteTable("mine")
}