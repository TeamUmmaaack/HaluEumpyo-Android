package com.ummaaack.halueumpyo.presentation.ui

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.ummaaack.halueumpyo.R
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.SeekBar
import androidx.lifecycle.MutableLiveData
import org.cardna.presentation.ui.alarm.adapter.DiaryResponseData
import java.util.*
import kotlin.collections.HashSet

class CalendarView : LinearLayout {
    lateinit var header: LinearLayout
    lateinit var gridView: GridView
    private lateinit var calendarAdapter: CalendarAdapter


    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {
        initControl(
            context,
            attrs!!
        )
    }

    constructor (context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    private fun assignUiElements() {
        // layout is inflated, assign local variables to components
        header = findViewById(R.id.calendar_header)
        gridView = findViewById(R.id.calendar_grid)
    }

    fun updateCalendar(events: HashSet<Date>, inputCalendar: Calendar) {
        val cells = ArrayList<Date>()
        inputCalendar.set(Calendar.DAY_OF_MONTH, 1)

        val monthBeginningCell = inputCalendar.get(Calendar.DAY_OF_WEEK) - 1
        inputCalendar.add(Calendar.DAY_OF_MONTH, -monthBeginningCell)

        while (cells.size < (Calendar.DAY_OF_MONTH) +
            inputCalendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        ) {
            cells.add(inputCalendar.time)
            inputCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        //gridView에 CalendarAdapter를 연결
        calendarAdapter = CalendarAdapter(context, cells, events, inputCalendar.get(Calendar.MONTH))
        gridView.adapter = calendarAdapter
    }

    private fun initControl(context: Context, attrs: AttributeSet) {
        val calendar = Calendar.getInstance()
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.canlendar_layout, this)
        assignUiElements()
        val eventDays: HashSet<Date> = HashSet()
        eventDays.add(Date())
        updateCalendar(eventDays, calendar)
    }

    fun addSeekbarChangeListener(seekbarChangeListener  : SeekBar.OnSeekBarChangeListener?){
        binding.bdsSlider.setOnSeekBarChangeListener(seekbarChangeListener )
    }
}