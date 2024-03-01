package com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user

import com.google.gson.annotations.SerializedName

data class NameResponse(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)