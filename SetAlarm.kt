package com.example.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import java.util.*

class SetAlarm : AppCompatActivity(), TimePickerDialog.OnTimeSetListener {

    private lateinit var binding: ViewDataBinding


    //필요한 변수들
    var medilist = mutableListOf<String>("직접입력")//코틀린에 존재하는 그냥 자료형, 여기에 데이터를 넣고 이걸 통째로 객체한테 할당하는 방식.
    lateinit var name : String//약 이름 저장용

    val inputElement = InputElement(this)
    //val removealret = RemoveAlert(this)

    //선택된 날짜, 시간 받아오기
    var startDateStr = ""
    var endDateStr = ""
    var timeStr= ""


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_alarm)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_set_alarm)


        //여기서부터 요소 찾아주고 각 기능 설정해주는 부분
        var mediList = findViewById<Spinner>(R.id.mediList)//얘가 객체
        val start_DatePick = findViewById<Button>(R.id.start_DatePick)
        val end_DatePick = findViewById<Button>(R.id.end_DatePick)
        val timePick = findViewById<Button>(R.id.button3)
        val alarmSave = findViewById<Button>(R.id.alarmSave)

        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, medilist)
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1)

        mediList.adapter = adapter


        //리스너 메소드들

        start_DatePick.setOnClickListener {
            //다이얼로그 띄움
        }


        mediList.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                //선택된 요소 보여지도록, position == 0 이면 edittext 띄우기
                if (position == 0) {//직접입력 요소가 선택되면
                    //다이얼로그 띄우기
                    inputElement.show_inputDig()
                    inputElement.setOnClickedListener(object : InputElement.ButtonClickListener{
                        override fun onClicked(medi_Name: String) {
                            medilist.add(medi_Name)//받아와서 약 이름 리스트에 추가
                        }
                    })

                } else {//직접 입력 외 이미 리스트에 존재하는 약을 선택했다면
                    name = mediList.selectedItem.toString()
                    //선택된 값 일단 저장해둠
                    //나중에 세팅창의 저장버튼이 눌리면, AlarmList 화면의 새로 생성되는 레이아룻에 전달해주어야함
                }

                /**removealret.show_removeAlert()//다이얼로그 띄우는 함수 적용, 두 번 눌러서 삭제되도록.
                medilist.removeAt(postion)//선택한 값 리스트에서 지우기 ,remove_alert의 삭제 버튼이 눌리면 실행되도록 할 것**/


            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //기본값 지정, 직접입력으로 두기
                mediList.setSelection(0)
            }


        }

        alarmSave.setOnClickListener {

        }

    }


    override fun onTimeSet(timpicker: TimePicker?, hour: Int, minute: Int) {//저장버튼 눌리면 호출할 함수

        var clock: Calendar = Calendar.getInstance()

        var hour = clock.set(Calendar.HOUR_OF_DAY, hour)
        var minute = clock.set(Calendar.MINUTE, minute)
        var sec = clock.set(Calendar.SECOND, 0)

        updateTimeText(clock)

        setAlarm(clock)


    }


    private fun updateTimeText(clock: Calendar){
        //버튼의 텍스트 요소를 업데이트해서 설정한 시간을 확인할 수 있도록 할 것인데, 얘가 그 역할을 하는 함수

        var default_time = clock.time
        //시간 텍스트를  버튼에 띄워야하는데..


    }

    private fun setAlarm(clock : Calendar){

        //여기서 알람매니저 사용
        var alarmManager : AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        var intent = Intent(this, NotificationReceive::class.java)
        var pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0)

        if(clock.before(Calendar.getInstance())){
            //이미 지난 시간을 선택했으면, 내일로 날짜를 +1해준다
            //어차피 현재시간(날짜포함)이랑 비교해서 따지는거니까 좀 더 완성되면 수정해보는걸로
            clock.add(Calendar.DATE,1)
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, clock.timeInMillis, pendingIntent)
    }








}