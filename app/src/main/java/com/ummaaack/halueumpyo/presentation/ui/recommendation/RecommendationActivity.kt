package com.ummaaack.halueumpyo.presentation.ui.recommendation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.databinding.ActivityRecommendationBinding
import com.ummaaack.halueumpyo.presentation.base.BaseViewUtil
import com.ummaaack.halueumpyo.presentation.ui.MainActivity
import com.ummaaack.halueumpyo.presentation.util.setStatusBarTransparent

class RecommendationActivity : BaseViewUtil.BaseAppCompatActivity<ActivityRecommendationBinding>(R.layout.activity_recommendation) {
    private val musicUrl = "https://www.youtube.com/watch?v=RgKAFK5djSk"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        this.setStatusBarTransparent()
        setGotoPlayClickListener()
    }

    private fun setGotoPlayClickListener() {
        binding.btnRecommendationGoToPlay.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(musicUrl))
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        startActivity(Intent(baseContext, MainActivity::class.java).apply {
            putExtra(RECOMMENDATION_KEY, RECOMMANDATION)
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        })

        super.onBackPressed()

    }

    companion object {
        const val RECOMMANDATION = "RECOMMANDATION"
        const val RECOMMENDATION_KEY = "RECOMMENDATION_KEY"
    }
}