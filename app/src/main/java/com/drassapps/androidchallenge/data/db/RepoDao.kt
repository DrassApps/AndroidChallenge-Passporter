package com.drassapps.androidchallenge.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RepoDao {

    @Query("SELECT DISTINCT * FROM RepoDB GROUP BY repoName ORDER BY id ASC")
    fun getAll(): Flow<List<RepoDB>>

    @Query("SELECT COUNT(id) FROM RepoDB")
    suspend fun repoCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepositories(repositories: List<RepoDB>)

}