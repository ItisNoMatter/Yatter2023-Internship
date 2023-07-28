package com.dmm.bootcamp.yatter2023.di

import android.content.Context
import com.dmm.bootcamp.yatter2023.auth.TokenProvider
import com.dmm.bootcamp.yatter2023.auth.TokenProviderImpl
import com.dmm.bootcamp.yatter2023.infra.api.YatterApi
import com.dmm.bootcamp.yatter2023.infra.api.YatterApiFactory
import com.dmm.bootcamp.yatter2023.infra.pref.MePreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.koin.dsl.module
import javax.inject.Singleton

internal val infraModule = module {
    single { MePreferences(get()) }
    single { YatterApiFactory().create() }

    factory<TokenProvider> { TokenProviderImpl(get()) }
}

@Module
@InstallIn(SingletonComponent::class)
internal object InfraModule {
    @Provides
    @Singleton
    fun provideMePreference(@ApplicationContext context: Context): MePreferences {
        return MePreferences(context)
    }

    @Provides
    @Singleton
    fun provideYatterApi(): YatterApi {
        return YatterApiFactory().create()
    }

    @Provides
    @Singleton
    fun provideTokenProvider(tokenProviderImpl: TokenProviderImpl): TokenProvider {
        return tokenProviderImpl
    }
}