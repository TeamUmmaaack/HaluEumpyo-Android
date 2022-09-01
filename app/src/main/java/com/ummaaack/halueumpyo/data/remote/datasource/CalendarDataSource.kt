package com.ummaaack.halueumpyo.data.remote.datasource


import com.ummaaack.halueumpyo.data.remote.model.RequestSignUpData
import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary
import com.ummaaack.halueumpyo.data.remote.model.ResponseSignUpData

interface CalendarDataSource {

    suspend fun getDiary(date: String): ResponseGetDiary

    suspend fun postSignUp(date: RequestSignUpData): ResponseSignUpData

}