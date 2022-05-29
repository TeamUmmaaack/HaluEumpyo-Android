package com.ummaaack.halueumpyo.domain.repository

import com.ummaaack.halueumpyo.data.remote.api.calendar.ResponseSearchFriendNameData
import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary

interface CalendarRepository {

    suspend fun getDiary(date: String): ResponseGetDiary

    suspend fun getSearchFriendName(): ResponseSearchFriendNameData
}