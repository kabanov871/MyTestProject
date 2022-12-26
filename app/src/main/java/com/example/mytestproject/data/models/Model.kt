package com.example.mytestproject.data.models

data class Model (
    val bank: Bank,
    val brand: String = "",
    val country: Country,
    val number: Number,
    val prepaid: Boolean = false,
    val scheme: String = "",
    val type: String = ""
)