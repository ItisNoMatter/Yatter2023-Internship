package com.dmm.bootcamp.yatter2023.di.domain.service

import com.dmm.bootcamp.yatter2023.di.domain.model.Me

interface GetMeService {
  suspend fun execute(): Me?
}
