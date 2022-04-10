package com.ummaaack.halueumpyo.presentation.ui.setting

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.databinding.ActivityMainBinding
import com.ummaaack.halueumpyo.databinding.ActivitySettingBinding
import com.ummaaack.halueumpyo.presentation.base.BaseViewUtil
import com.ummaaack.halueumpyo.presentation.util.StatusBarUtil

class SettingActivity : BaseViewUtil.BaseAppCompatActivity<ActivitySettingBinding>(R.layout.activity_setting) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        StatusBarUtil.setStatusBar(this, resources.getColor(R.color.white, null))
    }
}