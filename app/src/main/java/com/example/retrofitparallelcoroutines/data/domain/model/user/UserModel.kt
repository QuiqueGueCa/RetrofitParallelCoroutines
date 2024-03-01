package com.example.retrofitparallelcoroutines.data.domain.model.user

import com.example.retrofitparallelcoroutines.data.domain.model.BaseModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    val id: Int = 0,
    val name: String = "",
    val surname: String = "",
    val company: String = "",
    val salary: Float = 0.0f,
    val total: Float = 0.0f
) : BaseModel()
