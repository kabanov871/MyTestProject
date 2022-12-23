package com.example.mytestproject.data.network

import com.example.mytestproject.data.models.Model
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("{body}")
    fun getCardDetails(@Path("body") body: String): Model

}