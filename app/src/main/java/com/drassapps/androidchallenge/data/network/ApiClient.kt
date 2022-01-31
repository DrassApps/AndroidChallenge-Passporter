package com.drassapps.androidchallenge.data.network

import com.drassapps.androidchallenge.data.model.RepoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("repos")
    suspend fun getUserRepos(@Query("per_page") per_page: String,
                             @Query("page") page: String): Response<List<RepoModel>>
}