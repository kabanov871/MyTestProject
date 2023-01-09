package com.example.mytestproject.data.repository


import android.app.Activity
import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.mytestproject.R
import com.example.mytestproject.data.database.CardDao
import com.example.mytestproject.data.mapper.Mapper
import com.example.mytestproject.data.models.DbModel
import com.example.mytestproject.data.network.ApiInterface
import com.example.mytestproject.domain.Repository
import com.example.mytestproject.domain.UseCaseModel
import kotlinx.coroutines.*
import javax.inject.Inject

class RepositoryImpl @Inject constructor (
    private val mapper: Mapper,
    private val dao: CardDao,
    private val application: Application,
    private val api: ApiInterface
): Repository {

    override fun saveCard(body: String) {

        CoroutineScope(Dispatchers.IO).launch {
            api.getCardDetails(body).let {
                if (it.isSuccessful) {
                    val response = it.body()
                    if (response != null) {
                        dao.insert(
                            DbModel(
                                0,
                                body,
                                response.bank?.name,
                                response.bank?.phone,
                                response.bank?.url,
                                response.brand,
                                response.country.alpha2,
                                response.country.currency,
                                response.country.emoji,
                                response.country.latitude,
                                response.country.longitude,
                                response.country.name,
                                response.country.numeric,
                                response.number.length,
                                response.number.luhn,
                                response.prepaid,
                                response.scheme,
                                response.type
                            )

                        )
                    } else {  withContext(Dispatchers.Main){

                        Toast.makeText(application, R.string.loadFail, Toast.LENGTH_SHORT).show()
                    } }
                } else {  withContext(Dispatchers.Main){

                    Toast.makeText(application, R.string.loadFail, Toast.LENGTH_SHORT).show()
                } }
            }
        }
    }


    override fun getList(): LiveData<List<UseCaseModel>> = Transformations.map(dao.getAllCards()) {
        mapper.mapListToUseCase(it)
    }
}