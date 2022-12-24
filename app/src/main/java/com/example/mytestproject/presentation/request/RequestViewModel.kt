package com.example.mytestproject.presentation.request

import androidx.lifecycle.ViewModel
import com.example.mytestproject.domain.GetAndSaveUseCase
import com.example.mytestproject.domain.UseCaseModel

class RequestViewModel(private val useCase: GetAndSaveUseCase): ViewModel() {

    fun getAndSave(bin: String): UseCaseModel {
        return useCase.getAndSave(bin)
    }
}