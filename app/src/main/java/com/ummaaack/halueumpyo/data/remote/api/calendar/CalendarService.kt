package com.ummaaack.halueumpyo.data.remote.api.calendar

import com.ummaaack.halueumpyo.data.remote.model.RequestSignUpData
import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary
import com.ummaaack.halueumpyo.data.remote.model.ResponseSignUpData
import retrofit2.http.*

interface CalendarService {

    //일기 월별로 불러오기
    @GET("calendar/detail?date=")
    suspend fun getDiary(
        @Query("date") date: String
    ): ResponseGetDiary

    // 이름 등록 및 회원가입 API
    @POST("auth/signup")
    suspend fun postSignUp(
        @Body body: RequestSignUpData
    ): ResponseSignUpData


}


