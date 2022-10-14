package com.alireza.firstkmmapp.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    
    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return KtorClientFactory.build()
    }


    @Singleton
    @Provides
    fun provideApiService(httpClient: HttpClient): ApiService {
        return ApiServiceImp(
            httpClient = httpClient,
            baseUrl = "https:/test/api/",
            token = "2304923jedmw092d0293ke2ed"
        )
    }


}