package com.example.retrofitparallelcoroutines.data.domain.repository

import com.example.retrofitparallelcoroutines.data.domain.model.user.NamesListModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow

interface DataSource {
    fun getNamesList(): Flow<BaseResponse<NamesListModel>>
}