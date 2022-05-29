package com.ummaaack.halueumpyo.data.remote.datasource

import com.ummaaack.halueumpyo.data.remote.model.RequestPostDiary
import com.ummaaack.halueumpyo.data.remote.model.ResponsePostDiary

interface DiaryDataSource {

    suspend fun postDiary(body: RequestPostDiary): ResponsePostDiary
}