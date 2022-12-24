package com.example.mytestproject.data.repository

import android.app.Application
import com.example.mytestproject.data.database.CardDao
import com.example.mytestproject.data.mapper.Mapper
import com.example.mytestproject.data.network.ApiInterface
import com.example.mytestproject.domain.Repository
import com.example.mytestproject.domain.UseCaseModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val mapper: Mapper,
    private val dao: CardDao,
    private val api: ApiInterface,
    private val application: Application
): Repository {

    override fun getAndSave(body: String): UseCaseModel {

        val response = api.getCardDetails(body)

       // CoroutineScope(Dispatchers.IO).launch {
       //     kotlin.runCatching {
       //         withContext(Dispatchers.IO){
       //             api.getCardDetails(body)
       //         }

       //     }.onSuccess {
       //         // do something with success response
       //     }.onFailure{
       //         // do something on failure response
       //     }

       // }

        CoroutineScope(Dispatchers.IO).launch {

            dao.insert(mapper.mapModelToDbModel(body, response))

        }

        return mapper.mapModelToUseCaseModel(response)
    }

    override fun getList(): List<UseCaseModel> {

        return mapper.mapListToUseCase(dao.getAllCards())

    }

}