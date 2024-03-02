package com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.payroll

import com.example.retrofitparallelcoroutines.data.domain.model.payroll.NameModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.NameResponse

class NameMapper : ResponseMapper<NameResponse, NameModel> {
    override fun fromResponse(response: NameResponse): NameModel {
        return NameModel(
            response.id ?: -1,
            response.name ?: ""
        )
    }
}