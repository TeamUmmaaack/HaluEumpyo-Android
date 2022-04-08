package com.ummaaack.halueumpyo.presentation.ui.setting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.databinding.ActivityMainBinding
import com.ummaaack.halueumpyo.databinding.ActivitySettingBinding
import com.ummaaack.halueumpyo.presentation.base.BaseViewUtil

class SettingActivity : BaseViewUtil.BaseAppCompatActivity<ActivitySettingBinding>(R.layout.activity_setting) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
    }
}