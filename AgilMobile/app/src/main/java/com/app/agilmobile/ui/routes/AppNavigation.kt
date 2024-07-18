package com.app.agilmobile.ui.routes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
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
import com.app.agilmobile.ui.screens.LoginScreen
import com.app.agilmobile.ui.screens.MainScreen
import com.app.agilmobile.ui.screens.SplashScreen
import com.app.agilmobile.ui.sections.deliveries.CompleteDeliverySection
import com.app.agilmobile.ui.sections.deliveries.HomeSection
import com.app.agilmobile.ui.sections.deliveries.NextDeliverySection
import com.app.agilmobile.ui.sections.deliveries.packages.PackagesSection
import com.app.agilmobile.ui.sections.deliveries.ScriptsSection

object RoutesNavigationGraph {
    const val SPLASHSCREEN = "Splash"
    const val LOGIN = "login"
    const val MAINSCREEN = "mainScreen"
    const val HOME = "home"
    const val SCRIPTS = "scripts"
    const val PACKAGES = "packages"
    const val NEXT_DELIVERY = "next_delivery"
    const val COMPLETE_DELIVERY = "complete_delivery"
    const val PENDING = "pendentes"
    const val COMPLETED = "finalizados"
}

@Composable
fun AppNavigation () {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = SPLASHSCREEN ) {
        
        composable(route = SPLASHSCREEN) {
            SplashScreen(navController = navController)
        }
        composable(route = LOGIN){
            LoginScreen(navController = navController)
        }
        composable(route = MAINSCREEN) {
            MainScreen(navController = navController)
        }
        composable(route = HOME) {
            HomeSection()
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
//        composable(route = PENDING) {
//            CompleteDeliverySection()
//        }
//        composable(route = COMPLETE_DELIVERY) {
//            CompleteDeliverySection()
//        }
//

    }
}