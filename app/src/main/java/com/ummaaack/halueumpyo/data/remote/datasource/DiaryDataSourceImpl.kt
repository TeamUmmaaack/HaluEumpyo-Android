package com.ummaaack.halueumpyo.data.remote.datasource

import com.ummaaack.halueumpyo.data.remote.api.diary.DiaryService
import com.ummaaack.halueumpyo.data.remote.model.RequestPostDiary
import com.ummaaack.halueumpyo.data.remote.model.ResponsePostDiary
import javax.inject.Inject

class DiaryDataSourceImpl @Inject constructor(
    private val diaryService: DiaryService
) : DiaryDataSource {

    override suspend fun postDiary(body: RequestPostDiary): ResponsePostDiary {
        return diaryService.postDiary(body)
    }
}