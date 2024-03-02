package com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user

import com.google.gson.annotations.SerializedName

data class JobResponse(
    @SerializedName("job")
    val job: String?,
    @SerializedName("company")
    val company: String?,

    )
