package com.example.retrofitparallelcoroutines.data.domain.repository.remote

import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.NamesListResponse
import retrofit2.Response
import retrofit2.http.GET

interface RemoteApiService {
    @GET("names")
    suspend fun getNamesList(): Response<NamesListResponse>
}