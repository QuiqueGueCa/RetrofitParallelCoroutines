package com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.payroll

import com.example.retrofitparallelcoroutines.data.domain.model.payroll.SalaryModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.SalaryResponse

class SalaryMapper : ResponseMapper<SalaryResponse, SalaryModel> {
    override fun fromResponse(response: SalaryResponse): SalaryModel {
        return SalaryModel(
            response.salary ?: 0.0f,
            response.tax ?: 0,
            response.formation ?: 0.0f
        )
    }
}