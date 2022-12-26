package com.example.mytestproject.presentation.request

import androidx.lifecycle.ViewModel
import com.example.mytestproject.domain.GetCardUseCase
import com.example.mytestproject.domain.SaveCardUseCase
import com.example.mytestproject.domain.UseCaseModel
import javax.inject.Inject

class RequestViewModel @Inject constructor (
    private val saveUseCase: SaveCardUseCase,
    private val getUseCase: GetCardUseCase): ViewModel() {

    fun saveCard(bin: String){
        saveUseCase.saveCard(bin)
    }

    fun getCard(bin: String): UseCaseModel{
        return getUseCase.getCard(bin)
    }
}