package com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.payroll

import com.example.retrofitparallelcoroutines.data.domain.model.payroll.SurnameModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.SurnameResponse

class SurnameMapper : ResponseMapper<SurnameResponse, SurnameModel> {
    override fun fromResponse(response: SurnameResponse): SurnameModel {
        return SurnameModel(
            response.name ?: "",
            response.surname ?: ""
        )
    }
}