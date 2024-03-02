package com.example.retrofitparallelcoroutines.data.domain.repository

import com.example.retrofitparallelcoroutines.data.domain.model.payroll.JobModel
import com.example.retrofitparallelcoroutines.data.domain.model.payroll.NamesListModel
import com.example.retrofitparallelcoroutines.data.domain.model.payroll.PayrollModel
import com.example.retrofitparallelcoroutines.data.domain.model.payroll.SalaryModel
import com.example.retrofitparallelcoroutines.data.domain.model.payroll.SurnameModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow

interface DataSource {
    fun getNamesList(): Flow<BaseResponse<NamesListModel>>
    fun getSurname(idUser: Int): Flow<BaseResponse<SurnameModel>>
    fun getJob(idUser: Int): Flow<BaseResponse<JobModel>>
    fun getSalary(idUser: Int): Flow<BaseResponse<SalaryModel>>
    fun postPayroll(payrollModel: PayrollModel): Flow<BaseResponse<PayrollModel>>
}