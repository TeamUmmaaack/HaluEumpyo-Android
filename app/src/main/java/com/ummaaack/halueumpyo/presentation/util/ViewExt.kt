package com.ummaaack.halueumpyo.presentation.util

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import com.ummaaack.halueumpyo.R
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import androidx.annotation.IdRes
import androidx.core.view.WindowCompat
import com.ummaaack.halueumpyo.presentation.ui.recommendation.RecommendationActivity

fun Activity.setStatusBarTransparent() {
    window.apply {
        setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
    }
    if (Build.VERSION.SDK_INT >= 30) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}

@SuppressLint("ResourceType")
fun Context.showCustomDialog(@IdRes layout: Int): Dialog {
    val dialog = Dialog(this)
    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
    dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    dialog.setContentView(layout)
    dialog.setContentView(layout)
    dialog.setCancelable(false)
    dialog.getWindow()!!.setGravity(Gravity.CENTER)
    dialog.show()
    val animation = AnimationUtils.loadAnimation(this, R.anim.anim_dialog_recommendation)
    val loading = dialog.findViewById<ImageView>(R.id.iv_dialog_search_done)
    loading.startAnimation(animation)
    return dialog
}