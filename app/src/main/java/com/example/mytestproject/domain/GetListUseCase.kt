package com.example.mytestproject.domain

import javax.inject.Inject

class GetListUseCase @Inject constructor (private val repository: Repository) {

    fun getList(): List<UseCaseModel> {
        return repository.getList()
    }
}