package com.app.agilmobile.ui.routes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.COMPLETE_DELIVERY
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.HOME
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.NEXT_DELIVERY
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.PACKAGES
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.SCRIPTS
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.SPLASHSCREEN
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.LOGIN
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.MAINSCREEN
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.SERVICESCREEN
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.FUNCTION_CONSTRUCTION
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.EMPTY_SECTION
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.RECOVERY_PASSWORD
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.WALLET_SECTION
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.NAVIGATION_SCREEN
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.CHANGE_ROUTE_SCREEN
import com.app.agilmobile.ui.components.FunUnderConstruction
import com.app.agilmobile.ui.screens.ChangeRouteScreen
import com.app.agilmobile.ui.screens.LoginScreen
import com.app.agilmobile.ui.screens.MainScreen
import com.app.agilmobile.ui.screens.RecoveryPassScreen
import com.app.agilmobile.ui.screens.ServiceScreen
import com.app.agilmobile.ui.screens.SplashScreen
import com.app.agilmobile.ui.sections.EmptySection
import com.app.agilmobile.ui.sections.deliveries.CompleteDeliverySection
import com.app.agilmobile.ui.sections.deliveries.HomeSection
import com.app.agilmobile.ui.sections.deliveries.NextDeliverySection
import com.app.agilmobile.ui.sections.deliveries.packages.PackagesSection
import com.app.agilmobile.ui.sections.deliveries.ScriptsSection
import com.app.agilmobile.ui.sections.mainsScreen.wallet.Wallet
import com.example.composeapp.ui.screens.NavigationScreen

object RoutesNavigationGraph {
    const val SPLASHSCREEN = "Splash"
    const val LOGIN = "login"
    const val RECOVERY_PASSWORD = "recovery_password"
    const val MAINSCREEN = "main_screen"
    const val SERVICESCREEN = "service_screen"
    const val HOME = "home"
    const val SCRIPTS = "scripts"
    const val PACKAGES = "packages"
    const val NEXT_DELIVERY = "next_delivery"
    const val COMPLETE_DELIVERY = "complete_delivery"
    const val FUNCTION_CONSTRUCTION = "function_construction"
    const val EMPTY_SECTION = "empty_section"
    const val WALLET_SECTION = "wallet_section"
    const val NAVIGATION_SCREEN = "navigation_screen"
    const val CHANGE_ROUTE_SCREEN = "change_route_screen"

}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SPLASHSCREEN) {

        composable(route = SPLASHSCREEN) {
            SplashScreen(navController = navController)
        }
        composable(route = LOGIN) {
            LoginScreen(navController = navController)
        }
        composable(route = RECOVERY_PASSWORD) {
            RecoveryPassScreen(navController = navController)
        }
        composable(route = MAINSCREEN) {
            MainScreen(navController = navController)
        }
        composable(route = SERVICESCREEN) {
            ServiceScreen(navController = navController)
        }
        composable(route = NAVIGATION_SCREEN) {
            NavigationScreen(navController = navController)
        }
        composable(route = CHANGE_ROUTE_SCREEN) {
            ChangeRouteScreen(navController = navController)
        }
        composable(route = HOME) {
            HomeSection(navController = navController)
        }
        composable(route = SCRIPTS) {
            ScriptsSection()
        }
        composable(route = PACKAGES) {
            PackagesSection()
        }
        composable(route = NEXT_DELIVERY) {
            NextDeliverySection()
        }
        composable(route = COMPLETE_DELIVERY) {
            CompleteDeliverySection()
        }
        composable(route = FUNCTION_CONSTRUCTION) {
            FunUnderConstruction(navController = navController)
        }
        composable(route = EMPTY_SECTION) {
            EmptySection(navController = navController)
        }
        composable(route = WALLET_SECTION) {
            Wallet(navController = navController)
        }

//        composable(route = PENDING) {
//            CompleteDeliverySection()
//        }
//        composable(route = COMPLETE_DELIVERY) {
//            CompleteDeliverySection()
//        }

    }
}