package com.drassapps.androidchallenge.data.model

import com.google.gson.annotations.SerializedName

data class OwnerModel(
    @SerializedName("login") val login: String?,
    @SerializedName("html_url") val url: String?
)