package com.ummaaack.halueumpyo.presentation.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary
import com.ummaaack.halueumpyo.domain.repository.CalendarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val calendarRepository: CalendarRepository,
) : ViewModel() {

    private val _diaryList = MutableLiveData<List<ResponseGetDiary.Data>>()
    val diaryList: LiveData<List<ResponseGetDiary.Data>> = _diaryList

    private val _getDiaryListSuccess = MutableLiveData<Boolean>()
    val getDiaryListSuccess: LiveData<Boolean> = _getDiaryListSuccess


    fun getCalendar(date: String) {
        viewModelScope.launch {
            runCatching {
                calendarRepository.getDiary(date)
            }.onSuccess {
                _diaryList.value = it.data
            }
        }
    }
}

