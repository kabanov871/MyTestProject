package com.example.mytestproject.di

import android.app.Application
import com.example.mytestproject.presentation.MainActivity
import com.example.mytestproject.presentation.TestApp
import dagger.BindsInstance
import dagger.Component


@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}