package com.dmm.bootcamp.yatter2023.usecase.login

import com.dmm.bootcamp.yatter2023.di.domain.model.Password
import com.dmm.bootcamp.yatter2023.di.domain.model.Username

interface LoginUseCase {
  suspend fun execute(
      username: Username,
      password: Password,
  ): LoginUseCaseResult
}
