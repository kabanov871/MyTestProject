package com.example.mytestproject.presentation

import android.app.Application
import com.example.mytestproject.di.DaggerApplicationComponent

class TestApp: Application() {

    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}