package com.example.alarm

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AlarmList : AppCompatActivity() {

    //private lateinit var alarmplus: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm_list)

         val alarmplus = findViewById<FloatingActionButton>(R.id.alarmplus)//타입을 써줘야한다...!!

        alarmplus.setOnClickListener{
            val intent1 = Intent(this, SetAlarm::class.java)
            startActivity(intent1)
            //알람 추가하는 창 띄우기, 인텐트로 가야할듯
        }

    }
}