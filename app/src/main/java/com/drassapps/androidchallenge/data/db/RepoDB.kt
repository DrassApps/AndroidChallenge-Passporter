package com.drassapps.androidchallenge.data.db

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.drassapps.androidchallenge.data.domain.OwnerModel

@Entity
data class RepoDB(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val repoName: String,
    val repoDesc: String,
    val isFromFork: Boolean?,
    @Embedded val owner: OwnerModel
)