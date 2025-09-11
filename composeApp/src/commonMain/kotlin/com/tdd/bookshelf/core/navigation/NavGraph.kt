package com.tdd.bookshelf.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tdd.bookshelf.feature.onboarding.OnboardingScreen

fun NavGraphBuilder.onboardingNavGraph(
    navController: NavController,
) {
    navigation(
        startDestination = NavRoutes.OnboardingScreen.route,
        route = NavRoutes.OnboardingGraph.route
    ) {
        composable(NavRoutes.OnboardingScreen.route) {
            OnboardingScreen()
        }
    }
}