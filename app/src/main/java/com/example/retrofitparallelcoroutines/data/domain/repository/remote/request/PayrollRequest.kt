package com.example.retrofitparallelcoroutines.data.domain.repository.remote.request

import com.google.gson.annotations.SerializedName

data class PayrollRequest(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("surname")
    val surname: String?,
    @SerializedName("company")
    val company: String?,
    @SerializedName("salary")
    val salary: Float?
)
