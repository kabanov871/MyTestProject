package com.example.mytestproject.domain

interface Repository {

    fun getAndSave(body: String): UseCaseModel

    fun getList(): List<UseCaseModel>
}