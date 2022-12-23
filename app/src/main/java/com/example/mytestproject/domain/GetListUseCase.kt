package com.example.mytestproject.domain

class GetListUseCase (private val repository: Repository) {

    fun getList(): List<UseCaseModel> {
        return repository.getList()
    }
}