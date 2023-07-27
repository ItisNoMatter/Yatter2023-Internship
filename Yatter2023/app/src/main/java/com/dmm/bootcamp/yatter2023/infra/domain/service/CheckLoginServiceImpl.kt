package com.dmm.bootcamp.yatter2023.infra.domain.service

import com.dmm.bootcamp.yatter2023.di.domain.service.CheckLoginService
import com.dmm.bootcamp.yatter2023.infra.pref.MePreferences
import javax.inject.Inject

class CheckLoginServiceImpl @Inject constructor(
  private val mePreferences: MePreferences
) : CheckLoginService {
  override suspend fun execute(): Boolean {
    return mePreferences.getUsername() != ""
  }
}
