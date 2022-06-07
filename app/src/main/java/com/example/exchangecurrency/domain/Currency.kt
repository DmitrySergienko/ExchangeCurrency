package com.example.exchangecurrency.domain


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Currency(
    @SerializedName("date")
    val date: String,
    @SerializedName("historical")
    val historical: String,
    @SerializedName("info")
    val info: Info,
    @SerializedName("query")
    val query: Query,
    @SerializedName("result")
    val result: Double,
    @SerializedName("success")
    val success: Boolean
)