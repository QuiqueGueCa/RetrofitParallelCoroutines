package com.example.retrofitparallelcoroutines.data.domain.repository

import com.example.retrofitparallelcoroutines.data.domain.model.user.NamesListModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.RemoteDataSource
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow

object DataProvider : DataSource {

    override fun getNamesList(): Flow<BaseResponse<NamesListModel>> {
        return RemoteDataSource.getNamesList()
    }
}