package com.example.exchangecurrency.domain


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Info(
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("timestamp")
    val timestamp: Int
)