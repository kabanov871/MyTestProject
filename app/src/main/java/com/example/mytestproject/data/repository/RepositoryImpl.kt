package com.example.mytestproject.data.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.mytestproject.data.database.CardDao
import com.example.mytestproject.data.mapper.Mapper
import com.example.mytestproject.data.network.ApiInterface
import com.example.mytestproject.domain.Repository
import com.example.mytestproject.domain.UseCaseModel
import kotlinx.coroutines.*
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val mapper: Mapper,
    private val dao: CardDao,
    private val api: ApiInterface
): Repository {

    override fun saveCard(body: String) {

        CoroutineScope(Dispatchers.IO).launch {
            api.getCardDetails(body).let {
                if (it.isSuccessful) {
                    dao.insert(mapper.mapModelToDbModel(body,it.body()!!))
                }
            }
        }
    }


    override fun getList(): LiveData<List<UseCaseModel>> = Transformations.map(dao.getAllCards()) {
        mapper.mapListToUseCase(it)
    }
}