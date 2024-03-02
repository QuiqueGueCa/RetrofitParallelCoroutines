package com.example.retrofitparallelcoroutines.data.domain.repository

import com.example.retrofitparallelcoroutines.data.domain.model.user.JobModel
import com.example.retrofitparallelcoroutines.data.domain.model.user.NamesListModel
import com.example.retrofitparallelcoroutines.data.domain.model.user.SalaryModel
import com.example.retrofitparallelcoroutines.data.domain.model.user.SurnameModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.RemoteDataSource
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow

object DataProvider : DataSource {

    override fun getNamesList(): Flow<BaseResponse<NamesListModel>> {
        return RemoteDataSource.getNamesList()
    }

    override fun getSurname(idUser: Int): Flow<BaseResponse<SurnameModel>> {
        return RemoteDataSource.getSurname(idUser)
    }

    override fun getJob(idUser: Int): Flow<BaseResponse<JobModel>> {
        return RemoteDataSource.getJob(idUser)
    }

    override fun getSalary(idUser: Int): Flow<BaseResponse<SalaryModel>> {
        return RemoteDataSource.getSalary(idUser)
    }
}