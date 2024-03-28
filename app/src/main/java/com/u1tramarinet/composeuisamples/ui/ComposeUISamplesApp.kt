package com.u1tramarinet.composeuisamples.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.u1tramarinet.composeuisamples.ui.scrollbar.ScrollBarScreen

@Composable
fun ComposeUISamplesApp(
    navController: NavHostController = rememberNavController(),
    startDestination: String = ComposeUISamplesRoute.TOP,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ComposeUISamplesRoute.TOP) {
            TopScreen(onItemClick = {
                navController.navigate(it)
            })
        }
        composable(ComposeUISamplesRoute.SCROLL_BAR) {
            ScrollBarScreen()
        }
    }
}

object ComposeUISamplesRoute {
    const val TOP = "top"
    const val SCROLL_BAR = "scroll_bar"
}