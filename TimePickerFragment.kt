package com.example.alarm

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var clock: Calendar = Calendar.getInstance()
        var hour = clock.get(Calendar.HOUR_OF_DAY)
        var minute = clock.get(Calendar.MINUTE)

        return TimePickerDialog(activity, activity as TimePickerDialog.OnTimeSetListener, hour
        , minute, true)

    }


    interface ButtonClickListener{
        //알단 정의만, 얘 호출하는 액티비티에서 오버라이드 할 것
        fun onClicked(setted_time : String)
    }

    private lateinit var onClickedListener: ButtonClickListener

    fun setOnClickedListener(listener: ButtonClickListener){
        onClickedListener = listener
    }
}