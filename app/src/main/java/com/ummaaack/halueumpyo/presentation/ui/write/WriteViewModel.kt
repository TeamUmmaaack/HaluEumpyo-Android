package com.ummaaack.halueumpyo.presentation.ui.write

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ummaaack.halueumpyo.data.remote.model.RequestPostDiary
import com.ummaaack.halueumpyo.data.remote.model.ResponsePostDiary
import com.ummaaack.halueumpyo.domain.repository.DiaryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WriteViewModel @Inject constructor(
    private val diaryRepository: DiaryRepository,
) : ViewModel() {

    private val _isPostDiarySuccess = MutableLiveData<Boolean>()
    val isPostDiarySuccess: LiveData<Boolean> = _isPostDiarySuccess

    private val _response = MutableLiveData<ResponsePostDiary>()
    val response: LiveData<ResponsePostDiary> = _response

    fun postDiary(content: String) {
        viewModelScope.launch {
            runCatching {
                diaryRepository.postDiary(RequestPostDiary(content = content))
            }.onSuccess {
                _isPostDiarySuccess.value = true
                _response.value = it
            }.onFailure {
                Timber.e(it.toString())
            }
        }
    }
}

