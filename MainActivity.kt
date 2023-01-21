package com.example.alarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var editTextDate1: EditText
    private lateinit var editTextDate2: EditText
    private lateinit var editTextTime1: EditText

    private lateinit var saveBT: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveBT = findViewById<Button>(R.id.saveBT)

        editTextDate1 = findViewById(R.id.editTextDate1)
        editTextDate2 = findViewById(R.id.editTextDate2)
        editTextTime1 = findViewById(R.id.editTextTime1)

        //저장하기 버튼 눌리면 사용자가 입력한 값들을 저장해두는 동작
        saveBT.setOnClickListener {
            //
        }



    }
}