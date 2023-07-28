package com.dmm.bootcamp.yatter2023.di

import com.dmm.bootcamp.yatter2023.usecase.impl.login.LoginUseCaseImpl
import com.dmm.bootcamp.yatter2023.usecase.impl.post.PostStatusUseCaseImpl
import com.dmm.bootcamp.yatter2023.usecase.impl.register.RegisterAccountUseCaseImpl
import com.dmm.bootcamp.yatter2023.usecase.login.LoginUseCase
import com.dmm.bootcamp.yatter2023.usecase.post.PostStatusUseCase
import com.dmm.bootcamp.yatter2023.usecase.register.RegisterAccountUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.koin.dsl.module
import javax.inject.Singleton

internal val useCaseModule = module {
    factory<PostStatusUseCase> { PostStatusUseCaseImpl(get()) }
    factory<RegisterAccountUseCase> { RegisterAccountUseCaseImpl(get(), get()) }
    factory<LoginUseCase> { LoginUseCaseImpl(get()) }
}

@Module
@InstallIn(SingletonComponent::class)
internal object UseCaseModule {
    @Provides
    @Singleton
    fun providePostStatusUseCase(postStatusUseCaseImpl: PostStatusUseCaseImpl): PostStatusUseCase {
        return postStatusUseCaseImpl
    }

    @Provides
    @Singleton
    fun postRegisterAccountUseCase(registerAccountUseCaseImpl: RegisterAccountUseCaseImpl): RegisterAccountUseCase {
        return registerAccountUseCaseImpl
    }

    @Provides
    @Singleton
    fun provideLoginUseCase(loginUseCaseImpl: LoginUseCaseImpl): LoginUseCase {
        return loginUseCaseImpl
    }
}
