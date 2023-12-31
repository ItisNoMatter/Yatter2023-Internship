package com.dmm.bootcamp.yatter2023.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmm.bootcamp.yatter2023.di.domain.model.Password
import com.dmm.bootcamp.yatter2023.di.domain.model.Username
import com.dmm.bootcamp.yatter2023.usecase.login.LoginUseCase
import com.dmm.bootcamp.yatter2023.usecase.login.LoginUseCaseResult
import com.dmm.bootcamp.yatter2023.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
) : ViewModel() {
    private val _uiState: MutableStateFlow<LoginUiState> = MutableStateFlow(LoginUiState.empty())
    val uiState: StateFlow<LoginUiState> = _uiState

    private val _navigateToPublicTimeline: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToPublicTimeline: LiveData<Unit> = _navigateToPublicTimeline

    private val _navigateToRegister: SingleLiveEvent<Unit> = SingleLiveEvent()
    val navigateToRegister: LiveData<Unit> = _navigateToRegister

    fun onChangedUsername(username: String) {
        val snapshotBindingModel = uiState.value.loginBindingModel
        _uiState.update {
            it.copy(
                validUsername = Username(username).validate(),
                loginBindingModel = snapshotBindingModel.copy(
                    username = username
                )
            )
        }
    }


    fun onChangedPassword(password: String) {
        val snapshotBindingModel = uiState.value.loginBindingModel
        _uiState.update {
            it.copy(
                validPassword = Password(password).validate(),
                loginBindingModel = snapshotBindingModel.copy(
                    password = password
                )
            )
        }
    }

    fun onClickLogin() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) } // ローディング状態にする

            val snapBindingModel = uiState.value.loginBindingModel
            when (
                val result =
                    loginUseCase.execute(
                        Username(snapBindingModel.username),
                        Password(snapBindingModel.password),
                    ) // ログイン処理(LoginUseCase)実行
            ) {
                is LoginUseCaseResult.Success -> {
                    _navigateToPublicTimeline.value = Unit // ログイン処理成功したらパブリックタイムライン画面へ遷移
                }

                is LoginUseCaseResult.Failure -> {
                    println("login_failed")
                    // ログイン処理失敗したらエラー表示
                }
            }

            _uiState.update { it.copy(isLoading = true) } // ローディング状態を解除する
        }
    }

    fun onClickRegister() {
        _navigateToRegister.value = Unit
    }
}