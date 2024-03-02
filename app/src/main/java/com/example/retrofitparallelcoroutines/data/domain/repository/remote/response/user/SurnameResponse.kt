package com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user

import com.google.gson.annotations.SerializedName

data class SurnameResponse(
    @SerializedName("name")
    val name: String?,
    @SerializedName("surname")
    val surname: String?
)