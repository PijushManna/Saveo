package com.example.mvvmstarter.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
class RetroModule {
//    private val baseURL = "https://api.flickr.com/"
    private val baseURL = "https://randomuser.me/"

    @Provides
    @Singleton
    fun getRetroInstance():Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getRetroService(retrofit: Retrofit):RetroService {
        return retrofit.create(RetroService::class.java)
    }
}