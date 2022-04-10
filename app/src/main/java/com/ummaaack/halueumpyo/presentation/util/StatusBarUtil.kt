package com.ummaaack.halueumpyo.presentation.util

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View

object StatusBarUtil {
    @SuppressLint("InlinedApi")
    @Suppress("DEPRECATION")
    fun setStatusBar(activity: Activity, color: Int) {
        // 아이콘 색상을 어둡게 해줍니다
        activity.window?.decorView?.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        // 상태바 색상을 color의 색으로 맞춰줍니다
        activity.window?.statusBarColor = color
    }
}