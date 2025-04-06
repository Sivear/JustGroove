package com.sivear.justgroove

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sivear.justgroove.model.account.AccountModel
import com.sivear.justgroove.model.account.AccountTitle
import com.sivear.justgroove.preference.AccountPreference
import com.sivear.justgroove.route.RouteTable
import com.sivear.justgroove.ui.components.common.BottomNavigationBar
import com.sivear.justgroove.ui.screens.HomeScreen
import com.sivear.justgroove.ui.theme.JustGrooveTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        System.setProperty("dns.server", "8.8.8.8")
        enableEdgeToEdge()
        CoroutineScope(Dispatchers.IO).launch {
            mockAccountData(baseContext)
        }

        setContent {
            val navHostController: NavHostController = rememberNavController()
            JustGrooveTheme(dynamicColor = false) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar(navHostController)
                    }
                ) { innerPadding ->
                    NavHost(navHostController, startDestination = RouteTable.Home.route, Modifier.padding(innerPadding)) {
                        composable(RouteTable.Home.route) { HomeScreen() }
                        composable(RouteTable.Schedule.route) { Text("schedule") }
                        composable(RouteTable.Community.route) { Text("community") }
                        composable(RouteTable.Mine.route) { Text("mine") }
                    }

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JustGrooveTheme {
        Greeting("Android")
    }
}

// TODO: 后面加入登录相关功能后删除
suspend fun mockAccountData(ctx: Context) {
    val accountData = AccountModel("1", "白荻劲风", avatar = "https://images1.epochhk.com/pictures/i-epochtimes-com/b859c6c68c346decf16858dae13aa3db@1200x1200.jpg?url=https://i.epochtimes.com/assets/uploads/2020/04/shutterstock_473779396.jpg", title = AccountTitle.None)

    AccountPreference.getInstance().saveAccountInfo(ctx, accountData)
}