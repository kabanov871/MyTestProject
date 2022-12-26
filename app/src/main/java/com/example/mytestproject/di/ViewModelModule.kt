package com.example.mytestproject.di

import androidx.lifecycle.ViewModel
import com.example.mytestproject.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindHistoryViewModel(viewModel: MainViewModel): ViewModel
}