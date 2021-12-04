package com.example.saveo

import android.app.Application
import com.example.saveo.di.DaggerRetroComponent
import com.example.saveo.di.RetroComponent
import com.example.saveo.di.RetroModule

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