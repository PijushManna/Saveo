package com.example.saveo.di

import com.example.saveo.ui.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {
    fun inject(viewModel: MainViewModel)
}