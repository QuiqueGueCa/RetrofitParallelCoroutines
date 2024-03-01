package com.example.retrofitparallelcoroutines.data.domain.model.user

import com.example.retrofitparallelcoroutines.data.domain.model.BaseModel

data class NameModel(
    val id: Int = 0,
    val name: String = ""
) : BaseModel()
