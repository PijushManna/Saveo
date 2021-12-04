package com.example.mvvmstarter.di

import com.example.mvvmstarter.ui.main.MainViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RetroModule::class])
interface RetroComponent {
    fun inject(viewModel: MainViewModel)
}