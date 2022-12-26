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
        city = model.city,
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

    fun mapModelToDbModel(bin: String, model: Model) = DbModel(

        id = 0,
        bin = bin,
        city = model.bank.city,
        name = model.bank.name,
        phone = model.bank.phone,
        url = model.bank.url,
        brand = model.brand,
        alpha2 = model.country.alpha2,
        currency = model.country.currency,
        emoji = model.country.emoji,
        latitude = model.country.latitude,
        longitude = model.country.longitude,
        country = model.country.name,
        numeric = model.country.numeric,
        length = model.number.length,
        luhn = model.number.luhn,
        prepaid = model.prepaid,
        scheme = model.scheme,
        type = model.type
    )
}