package com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user

import com.google.gson.annotations.SerializedName

data class SalaryResponse(
    @SerializedName("salary")
    val salary: Float?,
    @SerializedName("tax")
    val tax: Int?,
    @SerializedName("formation")
    val formation: Float?
)
