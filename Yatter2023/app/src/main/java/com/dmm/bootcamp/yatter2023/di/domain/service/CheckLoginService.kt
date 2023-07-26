package com.dmm.bootcamp.yatter2023.di.domain.service

interface CheckLoginService {
  suspend fun execute(): Boolean
}
