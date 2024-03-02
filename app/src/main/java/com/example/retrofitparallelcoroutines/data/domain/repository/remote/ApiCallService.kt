package com.example.retrofitparallelcoroutines.data.domain.repository.remote

import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseApiCallService
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.JobResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.NamesListResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.SalaryResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.SurnameResponse

class ApiCallService(private val remoteApiService: RemoteApiService) : BaseApiCallService() {

    suspend fun getNamesList(): BaseResponse<NamesListResponse> {
        return apiCall { remoteApiService.getNamesList() }
    }

    suspend fun getSurname(idUser: Int): BaseResponse<SurnameResponse> {
        return apiCall { remoteApiService.getSurname(idUser) }
    }

    suspend fun getJob(idUser: Int): BaseResponse<JobResponse> {
        return apiCall { remoteApiService.getJob(idUser) }
    }

    suspend fun getSalary(idUser: Int): BaseResponse<SalaryResponse> {
        return apiCall { remoteApiService.getSalary(idUser) }
    }
}