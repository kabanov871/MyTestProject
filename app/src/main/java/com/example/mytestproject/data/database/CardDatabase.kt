package com.example.mytestproject.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mytestproject.data.models.DbModel

@Database(entities = [DbModel::class], version = 2)
abstract class CardDatabase: RoomDatabase() {

    abstract val cardDAO: CardDao

    companion object{
        @Volatile
        private var INSTANCE : CardDatabase? = null
        fun getInstance(context: Context):CardDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext, CardDatabase::class.java, "database2"
                    ).build()
                }
                return instance
            }
        }

    }
}