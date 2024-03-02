package com.example.retrofitparallelcoroutines.data.domain.repository.remote

import com.example.retrofitparallelcoroutines.data.domain.repository.remote.request.PayrollRequest
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseApiCallService
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.JobResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.NamesListResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.PayrollResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.SalaryResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.SurnameResponse

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

    suspend fun postPayroll(payrollRequest: PayrollRequest): BaseResponse<PayrollResponse> {
        return apiCall { remoteApiService.postPayroll(payrollRequest) }
    }
}