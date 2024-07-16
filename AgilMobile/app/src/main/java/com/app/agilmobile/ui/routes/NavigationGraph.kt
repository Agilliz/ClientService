package com.app.agilmobile.ui.routes

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.COMPLETE_DELIVERY
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.HOME
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.NEXT_DELIVERY
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.PACKAGES
import com.app.agilmobile.ui.routes.RoutesNavigationGraph.SCRIPTS
import com.app.agilmobile.ui.sections.deliveries.CompleteDeliverySection
import com.app.agilmobile.ui.sections.deliveries.HomeSection
import com.app.agilmobile.ui.sections.deliveries.NextDeliverySection
import com.app.agilmobile.ui.sections.deliveries.PackagesSection
import com.app.agilmobile.ui.sections.deliveries.ScriptsSection

object RoutesNavigationGraph {
    const val HOME = "home"
    const val SCRIPTS = "scripts"
    const val PACKAGES = "packages"
    const val NEXT_DELIVERY = "next_delivery"
    const val COMPLETE_DELIVERY = "complete_delivery"
}

@Composable
fun NavigationGraph (navController: NavController) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = HOME) {

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


    }
}