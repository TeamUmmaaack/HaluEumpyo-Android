package com.ummaaack.halueumpyo.data.remote.datasource

import com.ummaaack.halueumpyo.data.remote.api.calendar.CalendarService
import com.ummaaack.halueumpyo.data.remote.model.RequestSignUpData

import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary
import com.ummaaack.halueumpyo.data.remote.model.ResponseSignUpData
import javax.inject.Inject

class CalendarDataSourceImpl @Inject constructor(
    private val calendarService: CalendarService
) : CalendarDataSource {

    override suspend fun getDiary(date: String): ResponseGetDiary {
        return calendarService.getDiary(date=date)
    }

    override suspend fun postSignUp(body: RequestSignUpData): ResponseSignUpData {
        return calendarService.postSignUp(body)
    }
}