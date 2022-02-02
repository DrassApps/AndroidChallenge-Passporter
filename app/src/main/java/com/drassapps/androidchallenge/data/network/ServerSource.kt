package com.drassapps.androidchallenge.data.network

import com.drassapps.androidchallenge.data.domain.RemoteDataSource
import com.drassapps.androidchallenge.data.domain.RepoModel
import com.drassapps.androidchallenge.di.Network

class ServerSource: RemoteDataSource {

    private val api: ApiService = Network.service

    override suspend fun getRepositories(pageSize: Int, page: Int): List<RepoModel> =
        api.getUserRepos(pageSize, page)
}