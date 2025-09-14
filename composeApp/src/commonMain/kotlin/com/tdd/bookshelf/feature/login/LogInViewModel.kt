package com.tdd.bookshelf.feature.login

import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger.Companion.d
import com.tdd.bookshelf.core.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class LogInViewModel : BaseViewModel<LogInPageState>(
    LogInPageState()
) {

    fun onEmailValueChange(newValue: String) {
        updateState(
            uiState.value.copy(
                emailInput = newValue
            )
        )
    }

    fun onPasswordValueChange(newValue: String) {
        updateState(
            uiState.value.copy(
                passwordInput = newValue
            )
        )
    }

    fun postEmailLogIn() {
        viewModelScope.launch {
            //
        }

        d("[test] -> click")
    }
}