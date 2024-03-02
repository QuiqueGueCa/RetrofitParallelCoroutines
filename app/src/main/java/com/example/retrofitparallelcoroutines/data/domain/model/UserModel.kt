package com.example.retrofitparallelcoroutines.data.domain.model

data class UserModel(
    val id: Int = 0,
    val name: String = "",
    val surname: String = "",
    val company: String = "",
    val job: String = "",
    val salary: Float = 0.0f,
    val tax: Int = 0,
    val formation: Float = 0.0f,
    val total: Float = 0.0f
)
