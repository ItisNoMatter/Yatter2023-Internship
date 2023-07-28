package com.dmm.bootcamp.yatter2023.di.domain.service

import com.dmm.bootcamp.yatter2023.di.domain.model.Me
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


interface GetMeService {
  suspend fun execute(): Me?
}
