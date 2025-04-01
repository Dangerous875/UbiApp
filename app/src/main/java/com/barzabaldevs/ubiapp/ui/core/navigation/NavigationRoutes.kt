package com.barzabaldevs.ubiapp.ui.core.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavigationRoutes {
    @Serializable
    data object HomeScreenRoute : NavigationRoutes()
    @Serializable
    data class CoordinateScreenRoute(val latitude: Double, val longitude: Double) : NavigationRoutes()
}