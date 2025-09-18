package com.tdd.bookshelf.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.tdd.bookshelf.feature.detailchapter.DetailChapterScreen
import com.tdd.bookshelf.feature.home.HomeScreen
import com.tdd.bookshelf.feature.interview.InterviewScreen
import com.tdd.bookshelf.feature.login.LogInScreen
import com.tdd.bookshelf.feature.onboarding.OnboardingScreen

fun NavGraphBuilder.loginNavGraph(
    navController: NavController,
) {
    navigation(
        startDestination = NavRoutes.LogInScreen.route,
        route = NavRoutes.LogInGraph.route
    ) {
        composable(NavRoutes.LogInScreen.route) {
            LogInScreen(
                goToOnboardingPage = { navController.navigate(NavRoutes.OnboardingScreen.route) }
            )
        }
    }
}

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

fun NavGraphBuilder.homeNavGraph(
    navController: NavController,
) {
    navigation(
        startDestination = NavRoutes.HomeScreen.route,
        route = NavRoutes.HomeGraph.route
    ) {
        composable(NavRoutes.HomeScreen.route) {
            HomeScreen(
                goToInterviewPage = { navController.navigate(NavRoutes.InterviewScreen.route) },
                goToDetailChapterPage = { navController.navigate(NavRoutes.DetailChapterScreen.route) }
            )
        }
    }
}

fun NavGraphBuilder.interviewNavGraph(
    navController: NavController,
) {
    navigation(
        startDestination = NavRoutes.InterviewScreen.route,
        route = NavRoutes.InterviewGraph.route
    ) {
        composable(NavRoutes.InterviewScreen.route) {
            InterviewScreen()
        }
    }
}

fun NavGraphBuilder.detailChapterNavGraph(
    navController: NavController,
) {
    navigation(
        startDestination = NavRoutes.DetailChapterScreen.route,
        route = NavRoutes.DetailChapterGraph.route
    ) {
        composable(NavRoutes.DetailChapterScreen.route) {
            DetailChapterScreen()
        }
    }
}