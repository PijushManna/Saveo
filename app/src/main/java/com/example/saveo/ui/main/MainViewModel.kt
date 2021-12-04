package com.example.saveo.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.saveo.MyApplication
import com.example.saveo.di.RetroService
import com.example.saveo.models.FakeUser
import com.example.saveo.models.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG = "MainViewModel"
    private val _results = ArrayList<Result>()
    private val listAllData = MutableLiveData<List<Result>>()
    val allData: LiveData<List<Result>> = listAllData
    val currentItem = MutableLiveData<Result>()

    @Inject
    lateinit var repository:RetroService

    init {
        (application as MyApplication).getComponent().inject(this)
    }

    fun apiCall(){
        repository.getAllData(12)?.enqueue(object : Callback<FakeUser> {
            override fun onResponse(call: Call<FakeUser>, response: Response<FakeUser>) {
                response.body()?.let {
                    _results.addAll(it.results!!.toList())
                    listAllData.value = _results
                }
            }

            override fun onFailure(call: Call<FakeUser>, t: Throwable) {
                Log.i(TAG,t.message!!)
            }

        })
    }
}