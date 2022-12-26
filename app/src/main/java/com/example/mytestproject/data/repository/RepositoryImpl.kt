package com.example.mytestproject.data.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.mytestproject.data.database.CardDao
import com.example.mytestproject.data.mapper.Mapper
import com.example.mytestproject.data.models.Model
import com.example.mytestproject.data.network.ApiClient
import com.example.mytestproject.domain.Repository
import com.example.mytestproject.domain.UseCaseModel
import kotlinx.coroutines.*
import retrofit2.*
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val mapper: Mapper,
    private val dao: CardDao
): Repository {

    override fun saveCard(body: String) {

            val apiInterface = ApiClient.api.getCardDetails(body)

            apiInterface.enqueue(object : Callback<Model> {
                override fun onResponse(call: Call<Model>, response: Response<Model>) {

                    if (response.body() != null)
                        CoroutineScope(Dispatchers.IO).launch {

                            dao.insert(mapper.mapModelToDbModel(body, response.body()!!))

                        }
                }

                override fun onFailure(call: Call<Model>, t: Throwable) {

                }
            })
    }

    override fun getCard(body: String): UseCaseModel {

        return runBlocking { mapper.mapDbModelToUseCaseModel(dao.getCard(body)) }
    }

    override fun getList(): LiveData<List<UseCaseModel>> = Transformations.map(dao.getAllCards()) {
        mapper.mapListToUseCase(it)
    }
}