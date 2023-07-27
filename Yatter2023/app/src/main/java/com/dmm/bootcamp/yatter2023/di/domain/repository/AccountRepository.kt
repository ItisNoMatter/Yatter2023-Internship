package com.dmm.bootcamp.yatter2023.di.domain.repository

import com.dmm.bootcamp.yatter2023.di.domain.model.Account
import com.dmm.bootcamp.yatter2023.di.domain.model.Me
import com.dmm.bootcamp.yatter2023.di.domain.model.Password
import com.dmm.bootcamp.yatter2023.di.domain.model.Username
import java.net.URL

interface AccountRepository {
    suspend fun findMe(): Me?

    suspend fun findByUsername(username: Username): Account?

    suspend fun create(
        username: Username,
        password: Password
    ): Me

    suspend fun update(
        me: Me,
        newDisplayName: String?,
        newNote: String?,
        newAvatar: URL?,
        newHeader: URL?
    ): Me
}
