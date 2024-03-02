package com.example.retrofitparallelcoroutines.data.domain.repository.remote

import com.example.retrofitparallelcoroutines.data.domain.model.user.JobModel
import com.example.retrofitparallelcoroutines.data.domain.model.user.NamesListModel
import com.example.retrofitparallelcoroutines.data.domain.model.user.SalaryModel
import com.example.retrofitparallelcoroutines.data.domain.model.user.SurnameModel
import com.example.retrofitparallelcoroutines.data.domain.repository.DataSource
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.user.JobMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.user.NamesListMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.user.SalaryMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.user.SurnameMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

object RemoteDataSource : DataSource {

    //Aquí está la variable de la inyección de dependencias
    private val apiCallService = ApiCallService(RetrofitClient.getApiServices())
    override fun getNamesList(): Flow<BaseResponse<NamesListModel>> = flow {
        val apiResult = apiCallService.getNamesList()
        if (apiResult is BaseResponse.Success) {
            emit(BaseResponse.Success(NamesListMapper().fromResponse(apiResult.data)))
        } else if (apiResult is BaseResponse.Error) {
            emit(BaseResponse.Error(apiResult.error))
        }
    }

    override fun getSurname(idUser: Int): Flow<BaseResponse<SurnameModel>> = flow {
        val apiResult = apiCallService.getSurname(idUser)
        if (apiResult is BaseResponse.Success) {
            emit(BaseResponse.Success(SurnameMapper().fromResponse(apiResult.data)))
        } else if (apiResult is BaseResponse.Error) {
            emit(BaseResponse.Error(apiResult.error))
        }
    }

    override fun getJob(idUser: Int): Flow<BaseResponse<JobModel>> = flow {
        val apiResult = apiCallService.getJob(idUser)
        if (apiResult is BaseResponse.Success) {
            emit(BaseResponse.Success(JobMapper().fromResponse(apiResult.data)))
        } else if (apiResult is BaseResponse.Error) {
            emit(BaseResponse.Error(apiResult.error))
        }
    }

    override fun getSalary(idUser: Int): Flow<BaseResponse<SalaryModel>> = flow {
        val apiResult = apiCallService.getSalary(idUser)
        if (apiResult is BaseResponse.Success) {
            emit(BaseResponse.Success(SalaryMapper().fromResponse(apiResult.data)))
        } else if (apiResult is BaseResponse.Error) {
            emit(BaseResponse.Error(apiResult.error))
        }
    }
}