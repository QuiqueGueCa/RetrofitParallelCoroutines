package com.example.retrofitparallelcoroutines.data.domain.repository.remote.response

import com.example.retrofitparallelcoroutines.data.domain.model.error.ErrorModel

sealed class BaseResponse<T> {
    data class Success<T>(val data: T) : BaseResponse<T>()
    data class Error<T>(val error: ErrorModel) : BaseResponse<T>()
}
