package com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.user

import com.example.retrofitparallelcoroutines.data.domain.model.user.PayrollModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.RequestMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.PayrollResponse

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