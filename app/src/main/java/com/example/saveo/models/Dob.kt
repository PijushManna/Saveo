package com.example.saveo.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Dob (
    @SerializedName("date")
    @Expose
    var date: String? = null,

    @SerializedName("age")
    @Expose
    var age: Int? = null
)