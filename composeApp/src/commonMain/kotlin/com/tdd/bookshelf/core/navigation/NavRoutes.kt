package com.tdd.bookshelf.core.navigation

sealed class NavRoutes(val route: String) {

    // Onboarding Graph
    data object OnboardingGraph: NavRoutes("splash_graph")
    data object OnboardingScreen: NavRoutes("splash")
}