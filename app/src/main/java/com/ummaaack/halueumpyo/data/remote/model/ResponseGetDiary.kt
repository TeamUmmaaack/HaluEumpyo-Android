package com.ummaaack.halueumpyo.data.remote.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseGetDiary(
    @SerializedName("status")
    val status: Int,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("data")
    val `data`: List<Data>
) {
    data class Data(
        @SerializedName("id")
        var id: Int,
        @SerializedName("content")
        var content: String,
        @SerializedName("emotionId")
        var emotionId: Int,
        @SerializedName("title")
        var title: String,
        @SerializedName("singer")
        var singer: String,
        @SerializedName("cover")
        var cover: String,
        @SerializedName("url")
        var url: String,
        @SerializedName("createdAt")
        var createdAt: String
    ) : Serializable
}
