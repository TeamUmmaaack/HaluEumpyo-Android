package com.ummaaack.halueumpyo.data.remote.model

data class ResponsePostDiary(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data,
) {
    data class Data(
        val title: String,
        val singer: String,
        val cover: String,
        val url: String,
        val emotionId: Int,
    )
}