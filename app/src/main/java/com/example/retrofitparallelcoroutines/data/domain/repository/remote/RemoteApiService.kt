package com.example.retrofitparallelcoroutines.data.domain.repository.remote

import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.JobResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.NamesListResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.PayrollResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.SalaryResponse
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.SurnameResponse
import retrofit2.Response
import retrofit2.http.Body
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
    suspend fun postPayroll(
        @Body payroll: PayrollResponse
    ): Response<PayrollResponse>
}