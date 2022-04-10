package com.ummaaack.halueumpyo.presentation.ui

import android.content.Intent
import android.os.Bundle
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.databinding.ActivityMainBinding
import com.ummaaack.halueumpyo.presentation.base.BaseViewUtil
import com.ummaaack.halueumpyo.presentation.ui.seeall.SeeAllActivity
import com.ummaaack.halueumpyo.presentation.ui.setting.SettingActivity
import com.ummaaack.halueumpyo.presentation.ui.write.WriteActivity
import com.ummaaack.halueumpyo.presentation.util.StatusBarUtil

class MainActivity : BaseViewUtil.BaseAppCompatActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        StatusBarUtil.setStatusBar(this, resources.getColor(R.color.white, null))
        setClickListener()
    }

    private fun setClickListener() {
        with(binding) {
            ivMainSeeAll.setOnClickListener {
                startActivity(Intent(this@MainActivity, SeeAllActivity::class.java))
            }
            ivMainSetting.setOnClickListener {
                startActivity(Intent(this@MainActivity, SettingActivity::class.java))
            }
            ivMainWrite.setOnClickListener {
                startActivity(Intent(this@MainActivity, WriteActivity::class.java))
            }
        }
    }
}