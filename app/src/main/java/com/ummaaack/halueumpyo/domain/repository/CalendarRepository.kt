package com.ummaaack.halueumpyo.domain.repository

import com.ummaaack.halueumpyo.data.remote.model.RequestSignUpData
import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary
import com.ummaaack.halueumpyo.data.remote.model.ResponseSignUpData

interface CalendarRepository {

    suspend fun getDiary(date: String): ResponseGetDiary
    suspend fun postSignUp(body:RequestSignUpData): ResponseSignUpData

}