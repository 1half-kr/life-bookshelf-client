package com.tdd.bookshelf.feature.signup

import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger.Companion.d
import com.tdd.bookshelf.core.ui.base.BaseViewModel
import com.tdd.bookshelf.domain.entity.request.auth.EmailLogInRequestModel
import com.tdd.bookshelf.domain.entity.response.auth.AccessTokenModel
import com.tdd.bookshelf.domain.usecase.auth.SaveTokenUseCase
import com.tdd.bookshelf.feature.login.LogInEvent
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class SignUpViewModel(
    private val saveTokenUseCase: SaveTokenUseCase
): BaseViewModel<SignUpPageState>(
    SignUpPageState()
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

    fun postEmailSignUp() {
        viewModelScope.launch {
//            postEmailLogInUseCase(
//                EmailLogInRequestModel(
//                    email = uiState.value.emailInput,
//                    password = uiState.value.passwordInput,
//                )
//            ).collect {
//                resultResponse(it, ::onSuccessPostEmailLogIn)
//            }
        }
    }

    private fun onSuccessPostEmailLogIn(data: AccessTokenModel) {
        d("[ktor] sign up response -> $data")
        if (data.accessToken.isNotEmpty()) {
            saveAccessToken(data.accessToken)
            emitEventFlow(LogInEvent.GoToOnBoardingPage)
        }
    }

    private fun saveAccessToken(data: String) {
        viewModelScope.launch {
            saveTokenUseCase(data).collect {  }
        }
    }
}