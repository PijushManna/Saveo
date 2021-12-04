package com.example.mvvmstarter.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Street (
    @SerializedName("number")
    @Expose
    var number: Int? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null
)