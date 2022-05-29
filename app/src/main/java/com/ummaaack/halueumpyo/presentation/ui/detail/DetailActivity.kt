package com.ummaaack.halueumpyo.presentation.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatButton
import com.bumptech.glide.Glide
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary
import com.ummaaack.halueumpyo.databinding.ActivityDetailBinding
import com.ummaaack.halueumpyo.presentation.base.BaseViewUtil
import com.ummaaack.halueumpyo.presentation.util.StatusBarUtil
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DetailActivity : BaseViewUtil.BaseAppCompatActivity<ActivityDetailBinding>(R.layout.activity_detail) {
    private val musicUrl = "https://www.youtube.com/watch?v=RgKAFK5djSk"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        seffft()
        setGotoPlayClickListener()
        StatusBarUtil.setStatusBar(this, resources.getColor(R.color.white, null))
        binding.ivDetailMusicCover.setBackgroundResource(R.drawable.bg_rounding)
        binding.ivDetailMusicCover.clipToOutline = true
    }

    fun seffft() {
/*        data class Data(
            @SerializedName("id")
            var id: Int,
            @SerializedName("content")
            var content: String,
            @SerializedName("emotionId")
            var emotionId: Int,
            @SerializedName("title")
            var title: String,
            @SerializedName("singer")
            var singer: String,
            @SerializedName("cover")
            var cover: String,
            @SerializedName("url")
            var url: String,
            @SerializedName("createdAt")
            var createdAt: String
        ) : Serializable*/

        //"2022-05-02 Mon 23:01"
        val diary = intent?.getSerializableExtra("diary") as ResponseGetDiary.Data
        binding.tvDetailDay.text = diary.createdAt.substring(11..13) //요일
        binding.tvDetailDate.text = diary.createdAt.substring(0..9)
        binding.tvDetailContent.text = diary.content //내용
        binding.tvDetailMusicName.text = diary.title //노래제목
        binding.tvDetailMusicSinger.text = diary.singer //가수

        when (diary.emotionId) {
            1 -> binding.ivDetailEightNote.setImageResource(R.drawable.ic_eight_note_joy)
            2 -> binding.ivDetailEightNote.setImageResource(R.drawable.ic_eight_note_sad)
            3 -> binding.ivDetailEightNote.setImageResource(R.drawable.ic_eight_note_surprise)
            4 -> binding.ivDetailEightNote.setImageResource(R.drawable.ic_eight_note_angry)
            5 -> binding.ivDetailEightNote.setImageResource(R.drawable.ic_eight_note_hate)
            6 -> binding.ivDetailEightNote.setImageResource(R.drawable.ic_eight_note_fear)
            7 -> binding.ivDetailEightNote.setImageResource(R.drawable.ic_eight_note_soso)
            else -> binding.ivDetailEightNote.setImageResource(R.drawable.ic_eight_transparent)
        }


        Glide
            .with(this)
            .load(diary.cover)
            .centerCrop()
            .into(binding.ivDetailMusicCover)

    }


    private fun setGotoPlayClickListener() {
        binding.ivDetailMusic.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(musicUrl))
            startActivity(intent)
        }
    }
}