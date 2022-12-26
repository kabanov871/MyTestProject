package com.example.mytestproject.domain

import javax.inject.Inject

class GetCardUseCase @Inject constructor (private val repository: Repository) {

    fun getCard(body: String): UseCaseModel{
        return repository.getCard(body)
    }
}