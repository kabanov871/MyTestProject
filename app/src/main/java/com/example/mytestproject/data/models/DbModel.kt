package com.example.mytestproject.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="card_table")
data class DbModel (

    @PrimaryKey
    val id: Int,
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