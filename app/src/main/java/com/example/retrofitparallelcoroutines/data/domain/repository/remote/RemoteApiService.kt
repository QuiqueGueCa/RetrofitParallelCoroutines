package com.example.retrofitparallelcoroutines.data.domain.repository.remote

import com.example.retrofitparallelcoroutines.data.domain.repository.remote.response.user.NamesListResponse
import retrofit2.Response
import retrofit2.http.GET

interface RemoteApiService {
    @GET("names")
    suspend fun getNamesList(): Response<NamesListResponse>

    /*@GET("pokemon/{id}")
    suspend fun getPokemonDetail(
        @Path("id") idPokemon: Int
    ): Response<PokemonDetailResponse>*/
}