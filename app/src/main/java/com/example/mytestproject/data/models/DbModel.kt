package com.example.mytestproject.data.models


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="card_table")
data class DbModel (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val bin: String? = null,
    val name: String? = null,
    val phone: String? = null,
    val url: String? = null,
    val brand: String? = null,
    val alpha2: String? = null,
    val currency: String? = null,
    val emoji: String? = null,
    val latitude: Int? = null,
    val longitude: Int? = null,
    val country: String? = null,
    val numeric: String? = null,
    val length: Int? = null,
    val luhn: Boolean,
    val prepaid: Boolean,
    val scheme: String? = null,
    val type: String? = null
    )