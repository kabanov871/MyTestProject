package com.example.mytestproject.presentation.history

import androidx.lifecycle.ViewModel
import com.example.mytestproject.domain.GetListUseCase
import com.example.mytestproject.domain.UseCaseModel

class HistoryViewModel(private val useCase: GetListUseCase): ViewModel() {

    fun getList(): List<UseCaseModel> {
        return useCase.getList()
    }
}