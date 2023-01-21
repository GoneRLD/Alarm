package com.example.alarm

import android.app.Dialog
import android.content.Context
import android.view.WindowManager
import android.widget.Button


class RemoveAlert(context: Context) {

    private val removeAlert = Dialog(context)

    fun show_removeAlert(){

        val cancelBT = removeAlert.findViewById<Button>(R.id.rmcancel)
        val yesBT = removeAlert.findViewById<Button>(R.id.rmyes)

        removeAlert.setContentView(R.layout.remove_alert)

        removeAlert.window!!.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT)
        removeAlert.setCanceledOnTouchOutside(true)//다이얼로그 외부 터치하면, 다이얼로그 닫힘
        removeAlert.setCancelable(true)

        removeAlert.show()

        cancelBT.setOnClickListener {
            removeAlert.dismiss()
        }

        yesBT.setOnClickListener {

            //리스트 요소 삭제하는 코드는 SetAlarm.kt if-else 문으로 빼둠
            removeAlert.dismiss()
        }

    }


}