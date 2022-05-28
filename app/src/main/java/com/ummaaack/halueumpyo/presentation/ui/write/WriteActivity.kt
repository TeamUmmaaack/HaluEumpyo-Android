package com.ummaaack.halueumpyo.presentation.ui.write

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.core.widget.doAfterTextChanged
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.databinding.ActivityWriteBinding
import com.ummaaack.halueumpyo.presentation.base.BaseViewUtil
import com.ummaaack.halueumpyo.presentation.ui.recommendation.RecommendationActivity
import com.ummaaack.halueumpyo.presentation.util.StatusBarUtil
import com.ummaaack.halueumpyo.presentation.util.setStatusBarTransparent
import com.ummaaack.halueumpyo.presentation.util.showCustomDialog
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WriteActivity : BaseViewUtil.BaseAppCompatActivity<ActivityWriteBinding>(R.layout.activity_write) {

    private val writeViewModel: WriteViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        StatusBarUtil.setStatusBar(this, resources.getColor(R.color.white, null))
        setSend()
    }

    private fun setSend() {
        with(binding) {
            etWriteContent.doAfterTextChanged {
                if (!it.isNullOrEmpty()) {
                    ctvWriteSend.isChecked = true
                    setSendClickListener()
                } else {
                    ctvWriteSend.isChecked = false
                }
            }
        }
    }

    @SuppressLint("ResourceType")
    private fun setSendClickListener() {
        binding.ctvWriteSend.setOnClickListener {
            writeViewModel.postDiary(binding.etWriteContent.toString())
            val dialog = this.showCustomDialog(R.layout.dialog_recommendation)
            Handler(Looper.getMainLooper()).postDelayed({ dialog.dismiss() }, 4000)
            Handler(Looper.getMainLooper()).postDelayed({ gotoRecommendation() }, 4001)
        }
    }

    private fun gotoRecommendation() {
        writeViewModel.isPostDiarySuccess.observe(this) {
            if (it) {
                startActivity(Intent(this, RecommendationActivity::class.java))
                finish()
            }
        }
    }
}