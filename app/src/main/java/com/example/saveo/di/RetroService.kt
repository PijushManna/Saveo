package com.example.saveo.di

import com.example.saveo.models.FakeUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService{
    @GET("api")
    fun getAllData(@Query("results") i:Int):Call<FakeUser>?
}