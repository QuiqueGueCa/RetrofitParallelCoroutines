package com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll

import com.google.gson.annotations.SerializedName

data class NamesListResponse(
    @SerializedName("names")
    val names: MutableList<NameResponse>?
)

