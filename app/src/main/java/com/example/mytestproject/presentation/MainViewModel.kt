package com.example.mytestproject.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mytestproject.domain.GetListUseCase
import com.example.mytestproject.domain.SaveCardUseCase
import com.example.mytestproject.domain.UseCaseModel
import javax.inject.Inject

class MainViewModel @Inject constructor (
    private val getListUseCase: GetListUseCase,
    private val saveUseCase: SaveCardUseCase
    ): ViewModel() {

    fun getList(): LiveData<List<UseCaseModel>> {
        return getListUseCase.getList()
    }

    fun saveCard(bin: String){
        saveUseCase.saveCard(bin)
    }
}