package com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.payroll

import com.example.retrofitparallelcoroutines.data.domain.model.payroll.NameModel
import com.example.retrofitparallelcoroutines.data.domain.model.payroll.NamesListModel
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.mapper.ResponseMapper
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.payroll.NamesListResponse

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