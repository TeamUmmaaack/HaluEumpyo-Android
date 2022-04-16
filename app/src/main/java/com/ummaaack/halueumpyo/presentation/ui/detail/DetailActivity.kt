package com.ummaaack.halueumpyo.presentation.ui.detail

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.databinding.ActivityDetailBinding
import com.ummaaack.halueumpyo.presentation.base.BaseViewUtil
import com.ummaaack.halueumpyo.presentation.util.StatusBarUtil
import org.cardna.presentation.ui.alarm.adapter.DiaryResponseData

class DetailActivity : BaseViewUtil.BaseAppCompatActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        set()
        StatusBarUtil.setStatusBar(this, resources.getColor(R.color.white, null))
        binding.ivDetailMusicCover.setBackgroundResource(R.drawable.bg_rounding)
        binding.ivDetailMusicCover.clipToOutline = true
    }

    @SuppressLint("SetTextI18n")
    fun set() {

        val diary = intent?.getSerializableExtra("diary") as DiaryResponseData
        if(diary!=null){
  //      binding.tvDetailDate.text = "2022년${diary.month}월${diary.day}일"
  //      binding.tvDetailDay.text = "${diary.}요일"
        binding.tvDetailContent.text = diary.content
        binding.tvDetailMusicName.text = diary.musicName
        binding.tvDetailMusicSinger.text = diary.musicSinger
    }
}}