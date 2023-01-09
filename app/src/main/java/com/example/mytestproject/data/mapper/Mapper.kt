package com.example.mytestproject.data.mapper

import com.example.mytestproject.data.models.DbModel
import com.example.mytestproject.data.models.Model
import com.example.mytestproject.domain.UseCaseModel
import javax.inject.Inject

class Mapper @Inject constructor () {

    fun mapListToUseCase(list: List<DbModel>) = list.map { mapDbModelToUseCaseModel(it) }

    fun mapDbModelToUseCaseModel (model: DbModel) = UseCaseModel(

        id = 0,
        bin = model.bin,
        name = model.name,
        phone = model.phone,
        url = model.url,
        brand = model.brand,
        alpha2 = model.alpha2,
        currency = model.currency,
        emoji = model.emoji,
        latitude = model.latitude,
        longitude = model.longitude,
        country = model.country,
        numeric = model.numeric,
        length = model.length,
        luhn = model.luhn,
        prepaid = model.prepaid,
        scheme = model.scheme,
        type = model.type
    )

}