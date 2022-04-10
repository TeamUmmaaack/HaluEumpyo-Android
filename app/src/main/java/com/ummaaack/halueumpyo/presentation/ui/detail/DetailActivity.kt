package com.ummaaack.halueumpyo.presentation.ui.detail

import android.graphics.Color
import android.os.Bundle
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.databinding.ActivityDetailBinding
import com.ummaaack.halueumpyo.presentation.base.BaseViewUtil
import com.ummaaack.halueumpyo.presentation.util.StatusBarUtil

class DetailActivity : BaseViewUtil.BaseAppCompatActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        StatusBarUtil.setStatusBar(this, resources.getColor(R.color.white, null))
        binding.ivDetailMusicCover.setBackgroundResource(R.drawable.bg_rounding)
        binding.ivDetailMusicCover.clipToOutline = true
    }
}