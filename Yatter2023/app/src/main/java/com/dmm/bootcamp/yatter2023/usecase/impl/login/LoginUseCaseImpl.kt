package com.dmm.bootcamp.yatter2023.usecase.impl.login

import com.dmm.bootcamp.yatter2023.di.domain.model.Password
import com.dmm.bootcamp.yatter2023.di.domain.model.Username
import com.dmm.bootcamp.yatter2023.di.domain.service.LoginService
import com.dmm.bootcamp.yatter2023.usecase.login.LoginUseCase
import com.dmm.bootcamp.yatter2023.usecase.login.LoginUseCaseResult
import javax.inject.Inject

internal class LoginUseCaseImpl @Inject constructor(
    private val loginService: LoginService,
) : LoginUseCase {
    override suspend fun execute(
        username: Username,
        password: Password
    ): LoginUseCaseResult {
        try {
            if (username.value.isBlank()) return LoginUseCaseResult.Failure.EmptyUsername
            if (password.value.isBlank()) return LoginUseCaseResult.Failure.EmptyPassword

            if (!password.validate()) return LoginUseCaseResult.Failure.InvalidPassword
            loginService.execute(username, password)

            return LoginUseCaseResult.Success
        } catch (e: Exception) {
            return LoginUseCaseResult.Failure.OtherError(e)
        }
    }
}