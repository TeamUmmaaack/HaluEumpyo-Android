package com.ummaaack.halueumpyo.data.remote.api.diary

import com.ummaaack.halueumpyo.data.remote.model.RequestPostDiary
import com.ummaaack.halueumpyo.data.remote.model.ResponsePostDiary
import retrofit2.http.Body
import retrofit2.http.POST

interface DiaryService {

    //일기작성
    @POST("diary")
    suspend fun postDiary(
        @Body body: RequestPostDiary
    ): ResponsePostDiary
}