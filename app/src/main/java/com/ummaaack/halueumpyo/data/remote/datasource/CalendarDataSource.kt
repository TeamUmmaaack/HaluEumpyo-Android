package com.ummaaack.halueumpyo.data.remote.datasource

import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary

interface CalendarDataSource {

    suspend fun getDiary(date: String): ResponseGetDiary
}