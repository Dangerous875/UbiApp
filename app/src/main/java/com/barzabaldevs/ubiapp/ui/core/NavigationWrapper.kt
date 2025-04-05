package com.barzabaldevs.ubiapp.ui.core

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.barzabaldevs.ubiapp.ui.core.navigation.NavigationRoutes.*
import com.barzabaldevs.ubiapp.ui.screens.coordinateScreen.CoordinateScreen
import com.barzabaldevs.ubiapp.ui.screens.homeScreen.HomeScreen

@Composable
fun NavigationWrapper(padding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(
        modifier = Modifier.padding(padding),
        navController = navController,
        startDestination = HomeScreenRoute
    ) {
        composable<HomeScreenRoute> {
            HomeScreen(navigateToMap = {lat , long ->
                navController.navigate(CoordinateScreenRoute(lat,long))
            })
        }
        composable<CoordinateScreenRoute> {
            val safeArgs = it.toRoute<CoordinateScreenRoute>()
            CoordinateScreen(safeArgs.latitude, safeArgs.longitude)
        }
    }
}