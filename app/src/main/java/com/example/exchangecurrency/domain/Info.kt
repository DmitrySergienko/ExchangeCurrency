package com.example.exchangecurrency.domain


import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Keep
@Parcelize

data class Info(
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("timestamp")
    val timestamp: Int
): Parcelable