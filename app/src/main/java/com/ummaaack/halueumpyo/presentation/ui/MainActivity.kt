package com.ummaaack.halueumpyo.presentation.ui

import android.os.Bundle
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.databinding.ActivityMainBinding
import com.ummaaack.halueumpyo.presentation.base.BaseViewUtil

class MainActivity : BaseViewUtil.BaseAppCompatActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
    }
}