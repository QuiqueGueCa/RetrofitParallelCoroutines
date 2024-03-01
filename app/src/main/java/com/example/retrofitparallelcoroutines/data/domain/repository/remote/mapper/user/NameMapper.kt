package com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.user

import com.example.retrofitparallelcoroutines.data.domain.model.user.NameModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.NameResponse

class NameMapper : ResponseMapper<NameResponse, NameModel> {
    override fun fromResponse(response: NameResponse): NameModel {
        return NameModel(
            response.id ?: -1,
            response.name ?: ""
        )
    }
}