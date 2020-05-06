package com.e.finalproject

import android.media.Ringtone
import android.media.RingtoneManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.content_second.*
import java.util.*
import kotlin.concurrent.timerTask

class SecondActivity : AppCompatActivity() {

    lateinit var alarmSetTime: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val timer: Timer = Timer();


        btn_set.setOnClickListener {

            val hr = time_picker.hour
            val mi = time_picker.minute

            val ringtone: Ringtone = RingtoneManager.getRingtone(
                applicationContext,
                RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
            )
            timer.scheduleAtFixedRate(timerTask {

                var tcurrentTime = txt_clock.text.toString()

                var currentTime = tcurrentTime.replaceRange(5, 8, "")

                if (currentTime.equals(alarmTime())) {
                    ringtone.play()
                    val i = 0
                } else {
                    ringtone.stop()
                }

            }, 0, 1000)
        }
    }

    private fun alarmTime(): String {

        var alHours = time_picker.hour
        //val alMin = time_picker.minute
        val alMin:String;
        var alTime: String;

        if(time_picker.minute < 10){
            alMin = "0" + time_picker.minute.toString()
        }else
            alMin = time_picker.minute.toString()

        if (alHours > 12) {
            alHours = alHours - 12
            if (alHours < 10) {
                alTime = "0"

            } else
                alTime = ""
            alTime += alHours.toString() + ":" + alMin + " PM"
        } else {
            alTime = alHours.toString() + ":" + alMin + " AM"
        }

        alarmSetTime = alTime
        return alTime

    }

}
