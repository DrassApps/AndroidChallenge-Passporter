package com.drassapps.androidchallenge.data.db

import com.drassapps.androidchallenge.data.domain.LocalDataSource
import com.drassapps.androidchallenge.data.domain.RepoModel
import com.drassapps.androidchallenge.ui.common.toDomainRepo
import com.drassapps.androidchallenge.ui.common.toRoomRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RoomDataSource(db: ReposDataBase) : LocalDataSource {

    private val repoDao = db.repoDao()

    override suspend fun size(): Int = repoDao.repoCount()

    override suspend fun saveRepositories(repositories: List<RepoModel>) {
        repoDao.insertRepositories(repositories.map { it.toRoomRepo() })
    }

    override fun getRepositories(): Flow<List<RepoModel>> =
        repoDao.getAll().map { repos -> repos.map { it.toDomainRepo() } }
}