package com.dmm.bootcamp.yatter2023.di.domain.service

import com.dmm.bootcamp.yatter2023.di.domain.model.Password
import com.dmm.bootcamp.yatter2023.di.domain.model.Username
import dagger.Module


interface LoginService {
  suspend fun execute(username: Username, password: Password)
}