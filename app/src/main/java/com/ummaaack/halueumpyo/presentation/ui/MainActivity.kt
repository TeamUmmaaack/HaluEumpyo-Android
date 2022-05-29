package com.ummaaack.halueumpyo.presentation.ui

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.data.HaluEumpyoRepository
import com.ummaaack.halueumpyo.databinding.ActivityMainBinding
import com.ummaaack.halueumpyo.domain.repository.CalendarRepository
import com.ummaaack.halueumpyo.presentation.base.BaseViewUtil
import com.ummaaack.halueumpyo.presentation.ui.recommendation.RecommendationActivity
import com.ummaaack.halueumpyo.presentation.ui.seeall.SeeAllActivity
import com.ummaaack.halueumpyo.presentation.ui.setting.SettingActivity
import com.ummaaack.halueumpyo.presentation.ui.write.WriteActivity
import com.ummaaack.halueumpyo.presentation.ui.write.WriteViewModel
import com.ummaaack.halueumpyo.presentation.util.StatusBarUtil
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseViewUtil.BaseAppCompatActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HaluEumpyoRepository.serviceRating = false
        initView()
        setObserve()
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    private fun setObserve() {
        mainViewModel.diaryList.observe(this) {
       binding.cdvMain.updateCalendar(diaryList = it)
        }
    }

    override fun initView() {
        mainViewModel.getCalendar("2022-05-28")

        StatusBarUtil.setStatusBar(this, resources.getColor(R.color.white, null))
        setInitClickListener()

        intent.getStringExtra(RecommendationActivity.RECOMMENDATION_KEY)?.let {
            if (!HaluEumpyoRepository.serviceRating) {
                binding.ctlServiceContainer.visibility = View.VISIBLE
                setRating()
            }
        }
    }

    private fun setRating() {
        with(binding) {
            ratingBar.rating
            tvMainConfirm.setOnClickListener {
                val rating = ratingBar.rating
                dismissServiceRating()

                HaluEumpyoRepository.serviceRating = true
            }
        }
    }


    private fun setInitClickListener() {
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

    private fun dismissServiceRating() {
        Handler(Looper.getMainLooper())
            .postDelayed({
                binding.ctlServiceContainer.visibility = View.GONE
                Toast.makeText(this@MainActivity, "참여해주셔서 감사합니다", Toast.LENGTH_SHORT).show()
            }, 1300)
    }

}