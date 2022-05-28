package com.ummaaack.halueumpyo.data.remote.model

data class ResponseGetDiary(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data,
) {
    data class Data(
        val data: List<Diary>,
    )
}

data class Diary(
    val id:Int,
    val content:String,
    val emotionId:Int,
    val title:String,
    val singer:String,
    val cover:String,
    val url:String,
    val createdAt:String
)