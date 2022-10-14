package com.alireza.firstkmmapp.android.di

import com.alireza.firstkmmapp.data.network.ApiService
import com.alireza.firstkmmapp.data.network.ApiServiceImp
import com.alireza.firstkmmapp.data.network.KtorClientFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.http.Headers.Companion.build
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    
    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return KtorClientFactory().build()
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