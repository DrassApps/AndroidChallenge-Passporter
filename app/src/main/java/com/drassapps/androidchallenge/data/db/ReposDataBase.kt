package com.drassapps.androidchallenge.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [RepoDB::class], version = 1)
abstract class ReposDataBase : RoomDatabase() {

    abstract fun repoDao(): RepoDao
}