package com.ummaaack.halueumpyo.data.remote.datasource

import com.ummaaack.halueumpyo.data.remote.api.calendar.CalendarService
import com.ummaaack.halueumpyo.data.remote.api.calendar.ResponseSearchFriendNameData
import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary
import javax.inject.Inject

class CalendarDataSourceImpl @Inject constructor(
    private val calendarService: CalendarService
) : CalendarDataSource {

    override suspend fun getDiary(date: String): ResponseGetDiary {
        return calendarService.getDiary(date=date)
    }

    override suspend fun getSearchFriendName(): ResponseSearchFriendNameData{
        return calendarService.getSearchFriendName()
    }
}