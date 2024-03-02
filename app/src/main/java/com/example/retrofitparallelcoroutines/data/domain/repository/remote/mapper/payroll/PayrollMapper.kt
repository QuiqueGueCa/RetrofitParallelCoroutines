package com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.payroll

import com.example.retrofitparallelcoroutines.data.domain.model.payroll.PayrollModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.RequestMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.PayrollResponse

class PayrollMapper : RequestMapper<PayrollModel, PayrollResponse> {

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
}