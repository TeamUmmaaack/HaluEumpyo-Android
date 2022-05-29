package com.ummaaack.halueumpyo.data.remote.api.calendar

import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CalendarService {

    //일기 월별로 불러오기
    @GET("calendar/1?date")
    suspend fun getDiary(
        @Query("date") date: String
    ): ResponseGetDiary

    @GET("friend/list?name")
    suspend fun getSearchFriendName(
        @Header("token") platform: String="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MTA1LCJ1dWlkIjoiMjI0NDUxMjAxMCIsImxhc3ROYW1lIjoi6rmAIiwiZmlyc3ROYW1lIjoi64uk67mI7LKc7J6sIiwiY29kZSI6Iuq5gOuLpOu5iOyynOyerCMwNjI5IiwiaWF0IjoxNjUzNzYzMzM2LCJleHAiOjE2NTYzNTUzMzYsImlzcyI6ImNhcmRuYSJ9.BOd_thzNLo9vESUTdbTGL6J5ZEJygzoH82FEN-bpQ7Y",
        @Query("name") name: String="미누"
    ): ResponseSearchFriendNameData
}

data class ResponseSearchFriendNameData(
    val message: String,
    val status: Int,
    val success: Boolean,
    val data: MutableList<Data>,
) {
    data class Data(
        val id: Int,
        val name: String,
        val sentence: String?,
        val userImg: String
    )
}
