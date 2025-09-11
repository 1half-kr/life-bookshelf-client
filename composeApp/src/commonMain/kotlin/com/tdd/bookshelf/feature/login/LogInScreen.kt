package com.tdd.bookshelf.feature.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
internal fun LogInScreen(
    goToOnboardingPage: () -> Unit
) {
    LogInContent(
        onClickLogInBtn = { goToOnboardingPage() }
    )
}

@Composable
private fun LogInContent(
    onClickLogInBtn: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .align(Alignment.Center)
                .wrapContentSize()
                .clickable(
                    onClick = onClickLogInBtn
                )
        ) {
            Text(text = "LogIn")
        }
    }
}

@Preview
@Composable
fun PreviewLogIn() {
    LogInContent()
}