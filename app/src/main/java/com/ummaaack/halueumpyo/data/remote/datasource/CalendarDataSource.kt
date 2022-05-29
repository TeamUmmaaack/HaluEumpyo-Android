package com.ummaaack.halueumpyo.data.remote.datasource

import com.ummaaack.halueumpyo.data.remote.api.calendar.ResponseSearchFriendNameData
import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary

interface CalendarDataSource {

    suspend fun getDiary(date: String): ResponseGetDiary

    suspend fun getSearchFriendName(): ResponseSearchFriendNameData
}