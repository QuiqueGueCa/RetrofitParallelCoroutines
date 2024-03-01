package com.example.retrofitparallelcoroutines.data.domain.model.user

import com.example.retrofitparallelcoroutines.data.domain.model.BaseModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class JobModel(
    val job: String = "",
    val company: String = ""
) : BaseModel()
