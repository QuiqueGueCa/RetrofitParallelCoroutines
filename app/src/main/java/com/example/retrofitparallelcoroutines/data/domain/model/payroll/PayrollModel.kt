package com.example.retrofitparallelcoroutines.data.domain.model.payroll

import com.example.retrofitparallelcoroutines.data.domain.model.BaseModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class PayrollModel(
    val id: Int = 0,
    val name: String = "",
    val surname: String = "",
    val company: String = "",
    val salary: Float = 0.0f,
    val tax: Int = 0,
    val formation: Float = 0.0f,
    var total: Float = 0.0f
) : BaseModel() {

    init {
        total = salary - (salary * tax / 100) * formation
    }
}
