package com.tdd.bookshelf.feature

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.tdd.bookshelf.core.navigation.NavRoutes
import com.tdd.bookshelf.core.navigation.loginNavGraph
import com.tdd.bookshelf.core.navigation.onboardingNavGraph

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {},
        snackbarHost = {}
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .statusBarsPadding()
        ) {
            NavHost(
                navController = navController,
                startDestination = NavRoutes.LogInGraph.route
            ) {
                loginNavGraph(
                    navController = navController
                )
                onboardingNavGraph(
                    navController = navController
                )
            }
        }
    }
}