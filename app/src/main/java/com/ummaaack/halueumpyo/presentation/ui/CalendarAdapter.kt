package com.ummaaack.halueumpyo.presentation.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.appcompat.widget.AppCompatButton
import com.ummaaack.halueumpyo.R
import com.ummaaack.halueumpyo.data.remote.model.ResponseGetDiary
import com.ummaaack.halueumpyo.presentation.ui.detail.DetailActivity
import java.util.*

class CalendarAdapter(
    context: Context, days: ArrayList<Date>, eventDays: HashSet<Date>, inputMonth: Int,
    private val diaryList: List<ResponseGetDiary.Data>
) :
    ArrayAdapter<Date>(context, R.layout.canlendar_layout, days) {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val inputMonth = inputMonth - 1

    //오늘에 해당하는 캘린더를 가져옴
    val today = Date()
    val calendarToday = Calendar.getInstance()
    var myView: View? = null
    var list = mutableListOf<ResponseGetDiary.Data>().addAll(diaryList.toMutableList())

    init {
        for (it in diaryList.indices) {

        }

    }


    @SuppressLint("ResourceType", "ViewHolder")
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {

        myView = view
        val calendar = Calendar.getInstance()
        val date = getItem(position)

        calendar.time = date
        val day = calendar.get(Calendar.DATE)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)


        calendarToday.time = today

        //날짜 디자인으로 먼저 만들어 둔 calendar day layout을 inflate
        myView = inflater.inflate(R.layout.calendar_day_layout, parent, false)

        //뷰의 생김새와 일자 디자인 변경
        (myView as AppCompatButton).setTypeface(null, Typeface.NORMAL)
        (myView as AppCompatButton).setTextColor(Color.parseColor("#656565"))


        //요일 색깔 바꾸기F
        if (dayOfWeek == 1) {
            (myView as AppCompatButton).setTextColor(Color.parseColor("#A92626"))
        }
        if (dayOfWeek == 7) {
            (myView as AppCompatButton).setTextColor(Color.parseColor("#262CA9"))
        }

        //날짜를 텍스트뷰에 설정
        (myView as AppCompatButton).text = calendar.get(Calendar.DATE).toString()


        for (it in diaryList) {
            if (day == it.createdAt.let { if (it.toCharArray()[8] == '0') it.slice(9..9) else it.slice(8..9).toInt() }) {
                when (it.emotionId) {
                    1 -> (myView as AppCompatButton).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eight_note_joy_resize, 0);
                    2 -> (myView as AppCompatButton).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eight_note_sad_resize, 0);
                    3 -> (myView as AppCompatButton).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eight_note_surprise_resize, 0);
                    4 -> (myView as AppCompatButton).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eight_note_angry_resize, 0);
                    5 -> (myView as AppCompatButton).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eight_note_hate_resize, 0);
                    6 -> (myView as AppCompatButton).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eight_note_fear_resize, 0);
                    7 -> (myView as AppCompatButton).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eight_note_soso_resize, 0);
                    else -> (myView as AppCompatButton).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eight_note_angry_resize, 0);
                }
            }
        }

        if(day==7){
            (myView as AppCompatButton).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eight_note_soso_resize, 0);
        }
        if(day==2){
     (myView as AppCompatButton).setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.eight_note_surprise_resize, 0);
        }

        (myView as View).setOnClickListener {
            var detailIndex = "0"
            diaryList.forEachIndexed { index, it ->
                val hi = it.createdAt.let { if (it.toCharArray()[8] == '0') it.slice(9..9) else it.slice(8..9).toInt() }
                if (calendar.get(Calendar.DATE) == hi) {

                    detailIndex = index.toString()
                }
            }

            context.startActivity(Intent(context, DetailActivity::class.java).apply {
                putExtra(
                    "diary",
                    diaryList[detailIndex.toInt()]
                )
            })
        }

        return myView as View
    }
}
