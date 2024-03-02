package com.example.retrofitparallelcoroutines.data.domain.use_cases

import com.example.retrofitparallelcoroutines.data.domain.model.payroll.JobModel
import com.example.retrofitparallelcoroutines.data.domain.repository.DataProvider
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow

class GetJobUseCase {

    operator fun invoke(idUser: Int): Flow<BaseResponse<JobModel>> {
        return DataProvider.getJob(idUser)
    }
}