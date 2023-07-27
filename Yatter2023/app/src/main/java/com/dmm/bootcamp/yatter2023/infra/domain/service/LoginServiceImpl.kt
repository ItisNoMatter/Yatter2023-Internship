package com.dmm.bootcamp.yatter2023.infra.domain.service

import com.dmm.bootcamp.yatter2023.di.domain.model.Password
import com.dmm.bootcamp.yatter2023.di.domain.model.Username
import com.dmm.bootcamp.yatter2023.di.domain.service.LoginService
import com.dmm.bootcamp.yatter2023.infra.pref.MePreferences
import javax.inject.Inject

class LoginServiceImpl @Inject constructor(
  private val mePreferences: MePreferences
) : LoginService {

  override suspend fun execute(
      username: Username,
      password: Password
  ) {
    mePreferences.putUserName(username.value)
  }
}
