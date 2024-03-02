package com.example.retrofitparallelcoroutines.data.domain.repository.remote

import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.JobResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.NamesListResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.PayrollResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.SalaryResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.SurnameResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RemoteApiService {
    @GET("names")
    suspend fun getNamesList(): Response<NamesListResponse>

    @GET("surname/{id}")
    suspend fun getSurname(
        @Path("id") idUser: Int
    ): Response<SurnameResponse>

    @GET("job/{id}")
    suspend fun getJob(
        @Path("id") idUser: Int
    ): Response<JobResponse>

    @GET("salary/{id}")
    suspend fun getSalary(
        @Path("id") idUser: Int
    ): Response<SalaryResponse>

    @POST("payroll")
    suspend fun setPayroll(): Response<PayrollResponse>
}