package com.example.mytestproject.di

import androidx.lifecycle.ViewModel
import com.example.mytestproject.presentation.history.HistoryViewModel
import com.example.mytestproject.presentation.request.RequestViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RequestViewModel::class)
    fun bindRequestViewModel(viewModel: RequestViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel::class)
    fun bindHistoryViewModel(viewModel: HistoryViewModel): ViewModel
}