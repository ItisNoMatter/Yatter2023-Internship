package com.dmm.bootcamp.yatter2023.di.domain.service

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


interface CheckLoginService {
  suspend fun execute(): Boolean
}
