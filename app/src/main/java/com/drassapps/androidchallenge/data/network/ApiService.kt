package com.drassapps.androidchallenge.data.network

import com.drassapps.androidchallenge.data.domain.RepoModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("repos")
    suspend fun getUserRepos(@Query("per_page") pageSize: Int,
                             @Query("page") page: Int): List<RepoModel>
}
