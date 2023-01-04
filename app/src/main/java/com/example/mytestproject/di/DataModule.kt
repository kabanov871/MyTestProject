package com.example.mytestproject.di

import android.app.Application
import com.example.mytestproject.data.database.CardDao
import com.example.mytestproject.data.database.CardDatabase
import com.example.mytestproject.data.network.ApiInterface
import com.example.mytestproject.data.repository.RepositoryImpl
import com.example.mytestproject.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindRepository(impl: RepositoryImpl): Repository

    companion object {

        @Provides
        @ApplicationScope
        fun provideCardDao(application: Application): CardDao {
            return CardDatabase.getInstance(application).cardDAO
        }

        @Provides
        fun baseUrl() = "https://lookup.binlist.net/"

        @Provides
        @ApplicationScope
        fun provideRetrofit(baseUrl: String): ApiInterface =
            Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
    }
}