package com.tdd.bookshelf.feature.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun OnboardingScreen() {

    OnboardingContent()
}

@Composable
fun OnboardingContent() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "onboading test"
        )
    }
}

@Preview
@Composable
fun PreviewOnboarding() {
    OnboardingContent()
}