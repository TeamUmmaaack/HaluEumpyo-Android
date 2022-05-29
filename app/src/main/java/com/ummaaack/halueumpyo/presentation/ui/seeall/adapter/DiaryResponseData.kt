package org.cardna.presentation.ui.alarm.adapter

import java.io.Serializable


//TODO  서버연결 후 더미 리스트 삭제
data class DiaryResponseData(
    val month: String,
    val day: String,
    val content: String,
    val musicName: String,
    val musicSinger: String
):Serializable
