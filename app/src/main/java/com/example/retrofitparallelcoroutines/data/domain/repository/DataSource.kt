package com.example.retrofitparallelcoroutines.data.domain.repository

import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.NamesListResponse
import kotlinx.coroutines.flow.Flow

interface DataSource {
    fun getNamesList(): Flow<BaseResponse<NamesListResponse>>
}