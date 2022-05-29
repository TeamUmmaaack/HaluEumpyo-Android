package com.ummaaack.halueumpyo.data.repository

import com.ummaaack.halueumpyo.data.remote.api.calendar.ResponseSearchFriendNameData
import com.ummaaack.halueumpyo.data.remote.datasource.CalendarDataSource
import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary
import com.ummaaack.halueumpyo.domain.repository.CalendarRepository
import javax.inject.Inject

class CalendarRepositoryImpl @Inject constructor(
    private val calendarDataSource: CalendarDataSource
) : CalendarRepository {

    override suspend fun getDiary(date: String): ResponseGetDiary {
        return calendarDataSource.getDiary(date)
    }

    override suspend fun getSearchFriendName(): ResponseSearchFriendNameData {
        return calendarDataSource.getSearchFriendName()
    }
}