package com.drassapps.androidchallenge.di

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class ApiAuth(token: String) : Interceptor {

    private var credentials: String = ""

    init { this.credentials = "Bearer $token" }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response? {
        val request = chain.request()
        val authenticatedRequest = request.newBuilder()
            .header("Authorization", credentials)
            .build()
        return chain.proceed(authenticatedRequest)
    }
}