package com.example.calendarapplication

import android.os.Bundle
import android.view.View
import android.widget.CalendarView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calendarapplication.ui.theme.CalendarApplicationTheme
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date

class MainActivity : ComponentActivity() {

    private lateinit var mCalendarView: CalendarView
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pattern = "dd-MM-yyyy"
        val locale = Locale.getDefault()
        val currentDate = SimpleDateFormat(pattern, locale).format(Date())

        mCalendarView = findViewById(R.id.calendar)
        textView = findViewById(R.id.textview_display_date)
        mCalendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            val date= "$dayOfMonth / ${month + 1} / $year"
            display(date)
        }
    }
    private fun display(date: String){
        textView.text= date;
    }
}