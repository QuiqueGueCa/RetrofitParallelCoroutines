package com.example.retrofitparallelcoroutines.data.domain.use_cases

import com.example.retrofitparallelcoroutines.data.domain.model.user.NamesListModel
import com.example.retrofitparallelcoroutines.data.domain.repository.DataProvider
import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.BaseResponse
import kotlinx.coroutines.flow.Flow

class GetNamesListUseCase {

    operator fun invoke(): Flow<BaseResponse<NamesListModel>> {
        return DataProvider.getNamesList()
    }
}