package com.example.samplesocialnetwork.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository {
    private val coroutineContext = Dispatchers.IO
    private val mainApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(MainApi.BASE_URL)
        .build()
        .create(MainApi::class.java)

    suspend fun getPosts() = withContext(coroutineContext) {
        mainApi.getPosts()
            .execute()
            .body()
    }

    suspend fun createPost(title: String, body: String) = withContext(coroutineContext) {
        mainApi.createPost(
                Post(
                    userId = 1,
                    id = 0,
                    title = title,
                    body = body
                )
            )
            .execute()
            .body()
    }
}