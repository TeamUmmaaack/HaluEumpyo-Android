package com.ummaaack.halueumpyo.domain.repository

import com.ummaaack.halueumpyo.data.remote.model.RequestPostDiary
import com.ummaaack.halueumpyo.data.remote.model.ResponsePostDiary

interface DiaryRepository {

    suspend fun postDiary(body: RequestPostDiary): ResponsePostDiary
}