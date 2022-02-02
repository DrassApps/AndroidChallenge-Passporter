package com.drassapps.androidchallenge.data.domain

import com.google.gson.annotations.SerializedName

data class RepoModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val repoName: String,
    @SerializedName("description") val repoDesc: String,
    @SerializedName("fork") val isFromFork: Boolean?,
    @SerializedName("owner") val owner: OwnerModel
)
