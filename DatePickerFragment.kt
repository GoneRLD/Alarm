package com.example.alarm

import android.app.Dialog
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DatePickerFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var calendar1 = Calendar.getInstance()
        var start_year = calendar1.get(Calendar.YEAR)
        var start_month = calendar1.get(Calendar.MONTH)
        var start_day = calendar1.get(Calendar.DAY_OF_MONTH)



        return super.onCreateDialog(savedInstanceState)
    }


    interface ButtonClickListener{
        //알단 정의만, 얘 호출하는 액티비티에서 오버라이드 할 것
        fun onClicked(setted_start : String)
    }

    private lateinit var onClickedListener: ButtonClickListener

    fun setOnClickedListener(listener: ButtonClickListener){
        onClickedListener = listener
    }
}