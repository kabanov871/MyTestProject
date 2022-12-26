package com.example.mytestproject.di

import android.app.Application
import com.example.mytestproject.presentation.MainActivity
import com.example.mytestproject.presentation.TestApp
import com.example.mytestproject.presentation.history.HistoryFragment
import com.example.mytestproject.presentation.request.RequestFragment
import dagger.BindsInstance
import dagger.Component


@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    fun inject(fragment: RequestFragment)

    fun inject(fragment: HistoryFragment)

    fun inject(application: TestApp)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}