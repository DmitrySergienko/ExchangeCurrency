package com.example.exchangecurrency.domain


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Query(
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("from")
    val from: String,
    @SerializedName("to")
    val to: String
)