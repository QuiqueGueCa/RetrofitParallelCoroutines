package com.example.retrofitparallelcoroutines.data.domain.use_cases

import com.example.retrofitparallelcoroutines.data.domain.model.payroll.PayrollModel
import com.example.retrofitparallelcoroutines.data.domain.repository.DataProvider
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow

class PostPayrollUseCase {
    operator fun invoke(payrollModel: PayrollModel): Flow<BaseResponse<PayrollModel>> {
        return DataProvider.postPayroll(payrollModel)
    }
}