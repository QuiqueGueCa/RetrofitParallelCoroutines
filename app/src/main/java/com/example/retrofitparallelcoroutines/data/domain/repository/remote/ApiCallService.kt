package com.example.retrofitparallelcoroutines.data.domain.repository.remote

import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseApiCallService
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.NamesListResponse

class ApiCallService(private val remoteApiService: RemoteApiService) : BaseApiCallService() {

    suspend fun getNamesList(): BaseResponse<NamesListResponse> {
        return apiCall { remoteApiService.getNamesList() }
    }
}