package com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.user

import com.example.retrofitparallelcoroutines.data.domain.model.user.NameModel
import com.example.retrofitparallelcoroutines.data.domain.model.user.NamesListModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.NamesListResponse

class NamesListMapper : ResponseMapper<NamesListResponse, NamesListModel> {
    override fun fromResponse(response: NamesListResponse): NamesListModel {

        val namesModel = mutableListOf<NameModel>()
        if (!response.names.isNullOrEmpty()) {
            val nameMapper = NameMapper()
            response.names.forEach { nameResponse ->
                namesModel.add(nameMapper.fromResponse(nameResponse))
            }
        }
        return NamesListModel(namesModel)
    }
}