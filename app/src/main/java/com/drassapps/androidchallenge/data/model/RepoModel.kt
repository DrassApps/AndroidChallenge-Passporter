package com.drassapps.androidchallenge.data.model

import com.google.gson.annotations.SerializedName

data class RepoModel(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val repoName: String?,
    @SerializedName("description") val repoDesc: String?,
    @SerializedName("fork") val isFromFork: Boolean?,
    @SerializedName("language") val codeLanguage: String?,
    @SerializedName("forks_count") val usersForked: Int?,
    @SerializedName("stargazers_count") val stars: Int?,
    @SerializedName("html_url") val repoUrl: String?,
    @SerializedName("owner") val owner: OwnerModel?
)
