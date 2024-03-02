package com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.user

import com.example.retrofitparallelcoroutines.data.domain.model.user.JobModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.JobResponse

class JobMapper : ResponseMapper<JobResponse, JobModel> {
    override fun fromResponse(response: JobResponse): JobModel {
        return JobModel(
            response.job ?: "",
            response.company ?: ""
        )
    }
}