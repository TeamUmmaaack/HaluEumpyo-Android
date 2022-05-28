package com.ummaaack.halueumpyo.data.repository

import com.ummaaack.halueumpyo.data.remote.datasource.DiaryDataSource
import com.ummaaack.halueumpyo.data.remote.model.RequestPostDiary
import com.ummaaack.halueumpyo.data.remote.model.ResponsePostDiary
import com.ummaaack.halueumpyo.domain.repository.DiaryRepository
import javax.inject.Inject

class DiaryRepositoryImpl @Inject constructor(
    private val diaryDataSource: DiaryDataSource
) : DiaryRepository {

    override suspend fun postDiary(body: RequestPostDiary): ResponsePostDiary {
        return diaryDataSource.postDiary(body)
    }
}