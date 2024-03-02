package com.example.retrofitparallelcoroutines.data.domain.repository

import com.example.retrofitparallelcoroutines.data.domain.model.user.JobModel
import com.example.retrofitparallelcoroutines.data.domain.model.user.NamesListModel
import com.example.retrofitparallelcoroutines.data.domain.model.user.SalaryModel
import com.example.retrofitparallelcoroutines.data.domain.model.user.SurnameModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow

interface DataSource {
    fun getNamesList(): Flow<BaseResponse<NamesListModel>>
    fun getSurname(idUser: Int): Flow<BaseResponse<SurnameModel>>
    fun getJob(idUser: Int): Flow<BaseResponse<JobModel>>
    fun getSalary(idUser: Int): Flow<BaseResponse<SalaryModel>>
}