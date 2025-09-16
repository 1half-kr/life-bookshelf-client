package com.tdd.bookshelf.core.navigation

sealed class NavRoutes(val route: String) {

    // LogIn Graph
    data object LogInGraph: NavRoutes("login_graph")
    data object LogInScreen: NavRoutes("login")

    // Onboarding Graph
    data object OnboardingGraph: NavRoutes("splash_graph")
    data object OnboardingScreen: NavRoutes("splash")

    // Home Graph
    data object HomeGraph: NavRoutes("home_graph")
    data object HomeScreen: NavRoutes("home")
}