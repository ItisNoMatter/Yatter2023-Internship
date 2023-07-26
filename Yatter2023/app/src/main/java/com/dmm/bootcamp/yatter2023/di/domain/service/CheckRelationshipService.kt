package com.dmm.bootcamp.yatter2023.di.domain.service

import com.dmm.bootcamp.yatter2023.di.domain.model.Me
import com.dmm.bootcamp.yatter2023.di.domain.model.Relationship
import com.dmm.bootcamp.yatter2023.di.domain.model.Username

interface CheckRelationshipService {
  suspend fun execute(
      me: Me,
      usernameList: List<Username>
  ): List<Relationship>
}
