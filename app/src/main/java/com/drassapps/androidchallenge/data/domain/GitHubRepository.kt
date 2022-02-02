package com.drassapps.androidchallenge.data.domain

import kotlinx.coroutines.withTimeout
import kotlinx.coroutines.flow.Flow

private const val PAGE_SIZE = 10

class GitHubRepository (
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
) {
    fun getSavedRepositories(): Flow<List<RepoModel>> = localDataSource.getRepositories()

    suspend fun requireNewPage(lastVisible: Int) {
        val newRepos = withTimeout(5_000) {
            remoteDataSource.getRepositories(PAGE_SIZE, lastVisible)
        }
        localDataSource.saveRepositories(newRepos)
    }
}

interface RemoteDataSource {
    suspend fun getRepositories(pageSize: Int, page: Int): List<RepoModel>
}

interface LocalDataSource {
    suspend fun size(): Int
    suspend fun saveRepositories(repositories: List<RepoModel>)
    fun getRepositories(): Flow<List<RepoModel>>
}