package com.example.mytestproject.domain

import androidx.lifecycle.LiveData
import javax.inject.Inject

class GetListUseCase @Inject constructor (private val repository: Repository) {

    fun getList(): LiveData<List<UseCaseModel>> {
        return repository.getList()
    }
}