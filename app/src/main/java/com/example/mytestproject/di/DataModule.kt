package com.example.mytestproject.di

import android.app.Application
import com.example.mytestproject.data.database.CardDao
import com.example.mytestproject.data.database.CardDatabase
import com.example.mytestproject.data.network.ApiClient
import com.example.mytestproject.data.network.ApiInterface
import com.example.mytestproject.data.repository.RepositoryImpl
import com.example.mytestproject.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    fun bindRepository(impl: RepositoryImpl): Repository

    companion object {

        @Provides
        fun provideCardDao(application: Application): CardDao {
            return CardDatabase.getInstance(application).cardDAO
        }

        @Provides
        fun provideApiInterface():ApiInterface {
            return ApiClient.api
        }
    }
}