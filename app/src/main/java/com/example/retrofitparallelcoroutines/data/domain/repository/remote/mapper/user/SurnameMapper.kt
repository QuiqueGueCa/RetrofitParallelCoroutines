package com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.user

import com.example.retrofitparallelcoroutines.data.domain.model.user.SurnameModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.SurnameResponse

class SurnameMapper : ResponseMapper<SurnameResponse, SurnameModel> {
    override fun fromResponse(response: SurnameResponse): SurnameModel {
        return SurnameModel(
            response.name ?: "",
            response.surname ?: ""
        )
    }
}