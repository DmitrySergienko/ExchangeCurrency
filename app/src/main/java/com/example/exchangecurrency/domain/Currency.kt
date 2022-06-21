package com.example.exchangecurrency.domain


import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

private const val DATE = "date"
private const val HISTORICAL = "historical"
private const val INFO = "info"
private const val QUERY = "query"
private const val RESULT = "result"
private const val SUCCESS = "success"
@Keep
@Parcelize
data class Currency(
    @SerializedName(DATE)
    val date: String,
    @SerializedName(HISTORICAL)
    val historical: String,
    @SerializedName(INFO)
    val info: Info,
    @SerializedName(QUERY)
    val query: Query,
    @SerializedName(RESULT)
    val result: Double,
    @SerializedName(SUCCESS)
    val success: Boolean
): Parcelable