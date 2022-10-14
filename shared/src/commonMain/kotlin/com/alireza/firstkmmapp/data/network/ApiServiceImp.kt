package com.alireza.firstkmmapp.data.network

import com.alireza.firstkmmapp.domain.model.Recipe
import io.ktor.client.*
import io.ktor.client.request.*

class ApiServiceImp(
    private val httpClient: HttpClient,
    private val baseUrl: String = "https:test.ir/api/",
    private val token: String = "12039wj0fnmcweie0e129jed",
) : ApiService {
    override suspend fun search(page: String, query: String): List<Recipe> {
        return httpClient.get<List<Recipe>> {
            url("$baseUrl/search?page=$page&query=$query")
            header("Authorization", token)
        }
    }

    override suspend fun get(id: Int): Recipe {
        return httpClient.get<Recipe> {
            url("$baseUrl/get/$id")
            header("Authorization", token)
        }
    }
}