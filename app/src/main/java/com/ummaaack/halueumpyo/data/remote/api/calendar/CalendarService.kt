package com.ummaaack.halueumpyo.data.remote.api.calendar

import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary
import retrofit2.http.GET
import retrofit2.http.Query

interface CalendarService {

    //일기 월별로 불러오기
    @GET("calendar/2/date")
    suspend fun getDiary(
        @Query("date") date: String
    ): ResponseGetDiary
}