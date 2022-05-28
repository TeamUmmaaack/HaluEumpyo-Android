package com.ummaaack.halueumpyo.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ummaaack.halueumpyo.data.remote.model.RequestPostDiary
import com.ummaaack.halueumpyo.domain.repository.CalendarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WriteViewModel @Inject constructor(
    private val calendarRepository: CalendarRepository,
) : ViewModel() {

    fun getCalendar(content: String) {
        viewModelScope.launch {
            runCatching {
                diaryRepository.postDiary(RequestPostDiary(content = content))
            }.onSuccess {
                _isPostDiarySuccess.value=true
                Log.e("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ","${it.data}")
            }.onFailure {
                Timber.e(it.toString())
            }
        }
    }

}