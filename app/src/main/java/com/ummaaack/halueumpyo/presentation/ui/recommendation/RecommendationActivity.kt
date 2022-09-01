package com.ummaaack.halueumpyo.presentation.ui.recommendation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.databinding.ActivityRecommendationBinding
import com.ummaaack.halueumpyo.domain.repository.DiaryRepository
import com.ummaaack.halueumpyo.presentation.base.BaseViewUtil
import com.ummaaack.halueumpyo.presentation.ui.MainActivity
import com.ummaaack.halueumpyo.presentation.ui.write.WriteViewModel
import com.ummaaack.halueumpyo.presentation.util.setStatusBarTransparent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class RecommendationActivity : BaseViewUtil.BaseAppCompatActivity<ActivityRecommendationBinding>(R.layout.activity_recommendation) {
    private val recommendationViewModel: RecommendationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        binding.vm = recommendationViewModel
    }

    override fun initView() {
        this.setStatusBarTransparent()
        val title = intent.getStringExtra("title") ?: ""
        val singer = intent.getStringExtra("singer") ?: ""
        val cover = intent.getStringExtra("cover") ?: ""
        val url = intent.getStringExtra("url") ?: ""
        val emotionId = intent.getIntExtra("emotionId", -1)
        recommendationViewModel.set(title, singer, cover, url, emotionId)

        setGotoPlayClickListener()
    }

    private fun setGotoPlayClickListener() {
        binding.btnRecommendationGoToPlay.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=sPcZnHf_3MQ"))
            startActivity(intent)
        }

 /*       binding.tvRecommendationMusicName.text = recommendationViewModel.title.value
        binding.tvRecommendationMusicSinger.text = recommendationViewModel.singer.value*/
        recommendationViewModel.emotionId.observe(this) {
            when (it) {
                1 -> binding.bg.setBackgroundResource(R.drawable.img_joy)
                2 -> binding.bg.setBackgroundResource(R.drawable.img_sad)
                3 -> binding.bg.setBackgroundResource(R.drawable.img_surprise)
                4 -> binding.bg.setBackgroundResource(R.drawable.img_angry)
                5 -> binding.bg.setBackgroundResource(R.drawable.img_hate)
                6 -> binding.bg.setBackgroundResource(R.drawable.img_fear)
                7 -> binding.bg.setBackgroundResource(R.drawable.img_soso)
                else -> binding.bg.setBackgroundResource(R.drawable.img_angry)
            }
        }


        Glide.with(this)
            .load("https://image.bugsm.co.kr/album/images/500/149170/14917009.jpg")
            .centerCrop()
            .into(binding.ivRecommendationMusicCover)
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


@HiltViewModel
class RecommendationViewModel @Inject constructor(
) : ViewModel() {
    val _title = MutableLiveData<String>()
    val title: LiveData<String> = _title

    val _singer = MutableLiveData<String>()
    val singer: LiveData<String> = _singer

    val _cover = MutableLiveData<String>()
    val cover: LiveData<String> = _cover

    val _url = MutableLiveData<String>()
    val url: LiveData<String> = _url

    val _emotionId = MutableLiveData<Int>()
    val emotionId: LiveData<Int> = _emotionId

    fun set(title2: String, singer2: String, cover2: String, url2: String, emotionId2: Int) {
        _title.value = title2
        _singer.value = singer2
        _cover.value = cover2
        _url.value = url2
        _emotionId.value = emotionId2
    }
}
