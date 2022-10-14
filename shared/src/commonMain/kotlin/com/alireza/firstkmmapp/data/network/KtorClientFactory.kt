package com.alireza.firstkmmapp.data.network

import io.ktor.client.*

expect class KtorClientFactory {
    fun build():HttpClient
}