package com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.payroll

import com.example.retrofitparallelcoroutines.data.domain.model.payroll.JobModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.JobResponse

class JobMapper : ResponseMapper<JobResponse, JobModel> {
    override fun fromResponse(response: JobResponse): JobModel {
        return JobModel(
            response.job ?: "",
            response.company ?: ""
        )
    }
}