package com.example.mytestproject.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mytestproject.data.models.DbModel

@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dbModel: DbModel)

    @Query("SELECT * from card_table")
    fun getAllCards(): List<DbModel>

}