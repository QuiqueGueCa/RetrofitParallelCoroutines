package com.example.retrofitparallelcoroutines.data.domain.repository.remote

import com.example.retrofitparallelcoroutines.data.domain.model.user.NamesListModel
import com.example.retrofitparallelcoroutines.data.domain.repository.DataSource
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.user.NamesListMapper
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
}