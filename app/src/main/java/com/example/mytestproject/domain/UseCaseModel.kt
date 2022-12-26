package com.example.mytestproject.domain

import javax.inject.Inject

data class UseCaseModel @Inject constructor (

    val id: Int,
    val bin: String,
    val city: String,
    val name: String,
    val phone: String,
    val url: String,
    val brand: String,
    val alpha2: String,
    val currency: String,
    val emoji: String,
    val latitude: Int,
    val longitude: Int,
    val country: String,
    val numeric: String,
    val length: Int,
    val luhn: Boolean,
    val prepaid: Boolean,
    val scheme: String,
    val type: String
    )