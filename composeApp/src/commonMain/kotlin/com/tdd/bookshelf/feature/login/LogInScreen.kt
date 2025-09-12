package com.tdd.bookshelf.feature.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import co.touchlab.kermit.Logger.Companion.d
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
internal fun LogInScreen(
    goToOnboardingPage: () -> Unit
) {

    val viewModel: LogInViewModel = koinViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LogInContent(
        onClickLogInBtn = {
            d("[test] click")
            goToOnboardingPage() }
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