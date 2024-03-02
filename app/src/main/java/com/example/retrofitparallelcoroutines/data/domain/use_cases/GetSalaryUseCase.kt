package com.example.retrofitparallelcoroutines.data.domain.use_cases

import com.example.retrofitparallelcoroutines.data.domain.model.payroll.SalaryModel
import com.example.retrofitparallelcoroutines.data.domain.repository.DataProvider
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow

class GetSalaryUseCase {
    operator fun invoke(idUser: Int): Flow<BaseResponse<SalaryModel>> {
        return DataProvider.getSalary(idUser)
    }
}