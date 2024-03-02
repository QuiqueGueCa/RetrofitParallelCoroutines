package com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.payroll

import com.example.retrofitparallelcoroutines.data.domain.model.payroll.PayrollModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.RequestMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.PayrollResponse

class PayrollMapper : RequestMapper<PayrollModel, PayrollResponse>,
    ResponseMapper<PayrollResponse, PayrollModel> {

    override fun toRequest(model: PayrollModel): PayrollResponse {
        return PayrollResponse(
            model.id,
            model.name,
            model.surname,
            model.company,
            model.salary,
            model.total
        )
    }

    override fun fromResponse(response: PayrollResponse): PayrollModel {
        return PayrollModel(
            response.id ?: 0,
            response.name ?: "",
            response.surname ?: "",
            response.company ?: "",
            response.salary ?: 0.0f,
            response.total ?: 0.0f
        )
    }
}