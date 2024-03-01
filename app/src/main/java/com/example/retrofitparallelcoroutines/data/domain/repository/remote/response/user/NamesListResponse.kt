package com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user

import com.google.gson.annotations.SerializedName

data class NamesListResponse(
    @SerializedName("names")
    val names: MutableList<NameResponse>?
)

