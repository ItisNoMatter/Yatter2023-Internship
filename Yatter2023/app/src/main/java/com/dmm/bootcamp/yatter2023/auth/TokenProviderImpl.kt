package com.dmm.bootcamp.yatter2023.auth

import android.accounts.AuthenticatorException
import com.dmm.bootcamp.yatter2023.di.domain.service.GetMeService

class TokenProviderImpl(private val getMeService: GetMeService) : TokenProvider {
  override suspend fun provide(): String {
    val me = getMeService.execute()
    return me?.username?.value?.let { "username $it" } ?: throw AuthenticatorException()
  }
}