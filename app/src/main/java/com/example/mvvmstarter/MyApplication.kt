package com.example.mvvmstarter

import android.app.Application
import com.example.mvvmstarter.di.DaggerRetroComponent
import com.example.mvvmstarter.di.RetroComponent
import com.example.mvvmstarter.di.RetroModule

class MyApplication : Application() {

    private lateinit var retroComponent:RetroComponent
    override fun onCreate() {
        super.onCreate()
        retroComponent = DaggerRetroComponent.builder()
            .retroModule(RetroModule())
            .build()
    }

    fun getComponent():RetroComponent{
        return retroComponent
    }
}