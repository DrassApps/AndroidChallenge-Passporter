package com.drassapps.androidchallenge.ui.common

import com.drassapps.androidchallenge.data.db.RepoDB
import com.drassapps.androidchallenge.data.domain.RepoModel

fun RepoModel.toRoomRepo(): RepoDB = RepoDB(
    0,
    repoName,
    repoDesc,
    isFromFork,
    owner
)

fun RepoDB.toDomainRepo(): RepoModel = RepoModel(
    0,
    repoName,
    repoDesc,
    isFromFork,
    owner
)