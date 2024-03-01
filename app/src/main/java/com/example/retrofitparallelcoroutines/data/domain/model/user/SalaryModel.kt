package com.example.retrofitparallelcoroutines.data.domain.model.user

import com.example.retrofitparallelcoroutines.data.domain.model.BaseModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class SalaryModel(
    val salary: Float = 0.0f,
    val tax: Int = 0,
    val formation: Float = 0.0f
) : BaseModel()
