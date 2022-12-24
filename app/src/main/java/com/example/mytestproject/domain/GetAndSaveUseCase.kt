package com.example.mytestproject.domain

import javax.inject.Inject

class GetAndSaveUseCase @Inject constructor (private val repository: Repository) {

    fun getAndSave(body: String): UseCaseModel {
        return repository.getAndSave(body)
    }
}