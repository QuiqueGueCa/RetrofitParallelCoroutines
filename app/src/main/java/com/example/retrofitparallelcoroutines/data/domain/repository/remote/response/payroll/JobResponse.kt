package com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll

import com.google.gson.annotations.SerializedName

data class JobResponse(
    @SerializedName("job")
    val job: String?,
    @SerializedName("company")
    val company: String?,

    )
