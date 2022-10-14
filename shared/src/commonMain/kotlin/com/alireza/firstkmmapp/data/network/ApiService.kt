package com.alireza.firstkmmapp.data.network

import com.alireza.firstkmmapp.domain.model.Recipe

interface ApiService {

    suspend fun search(
        page:String,
        query:String,
    ):List<Recipe>

    suspend fun get(id:Int):Recipe
}