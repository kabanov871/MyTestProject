package com.example.mytestproject.domain

import javax.inject.Inject

class SaveCardUseCase @Inject constructor (private val repository: Repository) {

    fun saveCard(body: String){
        repository.saveCard(body)
    }
}