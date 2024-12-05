package com.example.simplecomposeapicall.data

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("title") val title: String? = null,
    @SerializedName("body") val body: String? = null
)