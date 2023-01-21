package com.example.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat

class NotificationReceive: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent:  Intent?) {
        var notificationHelper: NotificationHelper = NotificationHelper(context)
        var notificationBuilder: NotificationCompat.Builder = notificationHelper.get_Channel_Notification()

        //notification 호출하는 구문
        notificationHelper.getManager().notify(1,notificationBuilder.build())

    }

}