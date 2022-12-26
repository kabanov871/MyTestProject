package com.example.mytestproject.domain

import androidx.lifecycle.LiveData

interface Repository {

    fun saveCard(body: String)

    fun getList(): LiveData<List<UseCaseModel>>

}