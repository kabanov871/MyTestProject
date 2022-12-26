package com.example.mytestproject.presentation.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mytestproject.domain.GetListUseCase
import com.example.mytestproject.domain.UseCaseModel
import javax.inject.Inject

class HistoryViewModel @Inject constructor (private val useCase: GetListUseCase): ViewModel() {

    fun getList(): LiveData<List<UseCaseModel>> {
        return useCase.getList()
    }
}