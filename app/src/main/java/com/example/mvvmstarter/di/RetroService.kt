package com.example.mvvmstarter.di

import com.example.mvvmstarter.models.FakeUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService{
    @GET("api")
    fun getAllData(@Query("results") i:Int):Call<FakeUser>?
}