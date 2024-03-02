package com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.user

import com.example.retrofitparallelcoroutines.data.domain.model.user.SalaryModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.SalaryResponse

class SalaryMapper : ResponseMapper<SalaryResponse, SalaryModel> {
    override fun fromResponse(response: SalaryResponse): SalaryModel {
        return SalaryModel(
            response.salary ?: 0.0f,
            response.tax ?: 0,
            response.formation ?: 0.0f
        )
    }
}