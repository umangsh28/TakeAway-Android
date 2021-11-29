package ug.sharma.takeaway.model


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("medium")
    val medium: String,
    @SerializedName("original")
    val original: String
)