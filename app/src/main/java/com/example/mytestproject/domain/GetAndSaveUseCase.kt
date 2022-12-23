package com.example.mytestproject.domain

class GetAndSaveUseCase (private val repository: Repository) {

    fun getAndSave(body: String): UseCaseModel {
        return repository.getAndSave(body)
    }
}