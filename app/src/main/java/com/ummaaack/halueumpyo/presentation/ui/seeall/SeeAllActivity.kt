package com.ummaaack.halueumpyo.presentation.ui.seeall

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.NumberPicker
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.databinding.ActivitySeeAllBinding
import com.ummaaack.halueumpyo.presentation.base.BaseViewUtil
import com.ummaaack.halueumpyo.presentation.ui.MainActivity
import com.ummaaack.halueumpyo.presentation.ui.MainViewModel
import com.ummaaack.halueumpyo.presentation.ui.detail.DetailActivity
import com.ummaaack.halueumpyo.presentation.util.StatusBarUtil
import dagger.hilt.android.AndroidEntryPoint
import org.cardna.presentation.ui.alarm.adapter.DiaryAdapter
import org.cardna.presentation.ui.alarm.adapter.DiaryResponseData
import java.util.*


@AndroidEntryPoint
class SeeAllActivity : BaseViewUtil.BaseAppCompatActivity<ActivitySeeAllBinding>(R.layout.activity_see_all) {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var diaryAdapter: DiaryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    override fun initView() {
        StatusBarUtil.setStatusBar(this, resources.getColor(R.color.white, null))
        setDiaryListAdapter()
        setDatePickerClickListener()
        mainViewModel.getCalendar("2022-05-28")
    }


    private fun setDiaryListAdapter() {

        diaryAdapter = DiaryAdapter { diary ->
            startActivity(Intent(this, DetailActivity::class.java).apply {
                putExtra("diary", diary)
            })
        }
        with(binding.rvSeeAll) {
            adapter = diaryAdapter
            layoutManager = LinearLayoutManager(this@SeeAllActivity)
        }
        mainViewModel.diaryList.observe(this) { diaryList ->
            diaryAdapter.submitList(diaryList)
        }
    }


    private fun setDatePickerClickListener() {
        binding.tvSeeAllDate.text = "2022년 5월"

        //  날짜 dialog
        binding.ivSeeAllDatePicker.setOnClickListener {

            val dialog = AlertDialog.Builder(this).create()
            val edialog = LayoutInflater.from(this)
            val mView = edialog.inflate(R.layout.dialog_date_picker, null)


            val year: NumberPicker = mView.findViewById(R.id.yearpicker_datepicker)
            val month: NumberPicker = mView.findViewById(R.id.monthpicker_datepicker)
            val cancel: Button = mView.findViewById(R.id.btn_dialog_date_picker_cancle)
            val save: Button = mView.findViewById(R.id.btn_dialog_date_picker_confirm)


            //  순환 안되게 막기
            year.wrapSelectorWheel = false
            month.wrapSelectorWheel = false

            //  editText 설정 해제
            year.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
            month.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS

            //  최소값 설정
            year.minValue = 2021
            month.minValue = 1

            //  최대값 설정
            year.maxValue = 2022
            month.maxValue = 12


            year.displayedValues = arrayOf("2021년", "2022년")
            month.displayedValues = arrayOf("1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월")


            //  취소 버튼 클릭 시
            cancel.setOnClickListener {
                dialog.dismiss()
                dialog.cancel()
            }

            //  완료 버튼 클릭 시
            save.setOnClickListener {
                binding.tvSeeAllDate.text = (year.value).toString() + "년" + " " + (month.value).toString() + "월"
                var month = (month.value.toString()).let {
                    if (it.length == 1) "0" + it
                    else it
                }
                mainViewModel.getCalendar("${(year.value).toString()}-" + "${month}" + "-1")
                dialog.dismiss()
                dialog.cancel()
            }


            dialog.setView(mView)
            dialog.create()
            dialog.show()


        }

    }
}