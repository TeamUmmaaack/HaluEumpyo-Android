package com.ummaaack.halueumpyo.presentation.ui.recommendation

import android.os.Bundle
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.databinding.ActivityRecommendationBinding
import com.ummaaack.halueumpyo.presentation.base.BaseViewUtil
import com.ummaaack.halueumpyo.presentation.util.setStatusBarTransparent

class RecommendationActivity : BaseViewUtil.BaseAppCompatActivity<ActivityRecommendationBinding>(R.layout.activity_recommendation) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        this.setStatusBarTransparent()
    }
}