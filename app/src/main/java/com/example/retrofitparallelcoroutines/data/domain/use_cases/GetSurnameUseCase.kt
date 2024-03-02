package com.example.retrofitparallelcoroutines.data.domain.use_cases

import com.example.retrofitparallelcoroutines.data.domain.model.payroll.SurnameModel
import com.example.retrofitparallelcoroutines.data.domain.repository.DataProvider
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow

class GetSurnameUseCase {
    operator fun invoke(idUser: Int): Flow<BaseResponse<SurnameModel>> {
        return DataProvider.getSurname(idUser)
    }
}