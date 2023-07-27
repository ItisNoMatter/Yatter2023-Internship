package com.dmm.bootcamp.yatter2023.di

import com.dmm.bootcamp.yatter2023.di.domain.repository.AccountRepository
import com.dmm.bootcamp.yatter2023.di.domain.repository.StatusRepository
import com.dmm.bootcamp.yatter2023.di.domain.service.CheckLoginService
import com.dmm.bootcamp.yatter2023.di.domain.service.GetMeService
import com.dmm.bootcamp.yatter2023.di.domain.service.LoginService
import com.dmm.bootcamp.yatter2023.infra.domain.repository.AccountRepositoryImpl
import com.dmm.bootcamp.yatter2023.infra.domain.repository.StatusRepositoryImpl
import com.dmm.bootcamp.yatter2023.infra.domain.service.CheckLoginServiceImpl
import com.dmm.bootcamp.yatter2023.infra.domain.service.GetMeServiceImpl
import com.dmm.bootcamp.yatter2023.infra.domain.service.LoginServiceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.koin.dsl.module
import javax.inject.Inject
import javax.inject.Singleton

internal val domainImplModule = module {
  single<AccountRepository> { AccountRepositoryImpl(get(), get()) }
  single<StatusRepository> { StatusRepositoryImpl(get(), get()) }

  //factory<CheckLoginService> { CheckLoginServiceImpl(get()) }
  factory<GetMeService> { GetMeServiceImpl(get()) }
  factory<LoginService> { LoginServiceImpl(get()) }
}

@Module
@InstallIn(SingletonComponent::class)
internal object DomainImplModule{
  @Provides
  @Singleton
  fun provideLoginService (loginServiceImpl: LoginServiceImpl):LoginService{
    return loginServiceImpl
  }
  @Provides
  @Singleton
  fun provideCheckLoginService(checkLoginServiceImpl: CheckLoginServiceImpl):CheckLoginService{
    return checkLoginServiceImpl
  }
  @Provides
  @Singleton
  fun provideGetMeService(getMeServiceImpl: GetMeServiceImpl):GetMeService{
    return getMeServiceImpl
  }
}
//abstract class _DomainImplModule{
//  @Binds
//  abstract  fun _provideLoginService(loginServiceImpl: LoginServiceImpl):LoginService
//}

