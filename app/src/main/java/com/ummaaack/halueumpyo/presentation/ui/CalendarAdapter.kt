package com.ummaaack.halueumpyo.presentation.ui

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import java.util.*
import com.ummaaack.halueumpyo.R
import kotlin.collections.ArrayList

class CalendarAdapter(context: Context, days: ArrayList<Date>, eventDays: HashSet<Date>, inputMonth: Int) :
    ArrayAdapter<Date>(context, R.layout.canlendar_layout, days) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val inputMonth = inputMonth - 1


    override fun getView(position: Int, view: View?, parent: ViewGroup): View {

        var view = view
        val calendar = Calendar.getInstance()
        val date = getItem(position)

        calendar.time = date
        val day = calendar.get(Calendar.DATE)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)

        //오늘에 해당하는 캘린더를 가져옴
        val today = Date()
        val calendarToday = Calendar.getInstance()
        calendarToday.time = today

        //날짜 디자인으로 먼저 만들어 둔 calendar day layout을 inflate
        if (view == null) {
            view = inflater.inflate(R.layout.calendar_day_layout, parent, false)
        }

        //뷰의 생김새와 일자 디자인 변경
        (view as TextView).setTypeface(null, Typeface.NORMAL)
        view.setTextColor(Color.parseColor("#656565"))

        if (month == calendarToday.get(Calendar.MONTH) && year == calendarToday.get(Calendar.YEAR) &&
            day == calendarToday.get(Calendar.DATE)
        ) {
            //오늘 날짜에 하고싶은거
        }

        //날짜를 텍스트뷰에 설정
        view.text = calendar.get(Calendar.DATE).toString()

        return view
    }




}