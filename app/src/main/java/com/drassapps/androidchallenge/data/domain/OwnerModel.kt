package com.drassapps.androidchallenge.data.domain

import com.google.gson.annotations.SerializedName

data class OwnerModel(
    @SerializedName("login") val login: String,
    @SerializedName("html_url") val url: String
)