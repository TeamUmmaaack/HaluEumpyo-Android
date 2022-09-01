package com.ummaaack.halueumpyo.data.remote.model

data class ResponseSignUpData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data,
) {
    data class Data(
        val email: String,
        val username: String,
        val accessToken: String,
        val refreshToken: String,
    )
}