package com.example.mytestproject.data.network

import com.example.mytestproject.data.models.Model
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("{body}")
    suspend fun getCardDetails(@Path("body") body: String): Response<Model>

}