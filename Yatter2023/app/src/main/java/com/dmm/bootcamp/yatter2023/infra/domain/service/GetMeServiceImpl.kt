package com.dmm.bootcamp.yatter2023.infra.domain.service

import com.dmm.bootcamp.yatter2023.di.domain.model.Me
import com.dmm.bootcamp.yatter2023.di.domain.repository.AccountRepository
import com.dmm.bootcamp.yatter2023.di.domain.service.GetMeService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetMeServiceImpl @Inject constructor(
    private val accountRepository: AccountRepository,
) : GetMeService {
    override suspend fun execute(): Me? = withContext(Dispatchers.IO) {
        accountRepository.findMe()
    }
}
