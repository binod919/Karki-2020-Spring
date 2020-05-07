package com.e.finalproject

import android.app.Activity
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.e.finalproject.fragments.AboutFragment

import kotlinx.android.synthetic.main.content_second.*
import java.util.*
import kotlin.concurrent.timerTask

class SecondActivity : AppCompatActivity(), AboutFragment.OnFragmentInteractionListener {

     var alarmSetTime: String? = null
    lateinit var aboutFragment:AboutFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val timer: Timer = Timer();
        aboutFragment = AboutFragment.newInstance()

        val ringtone: Ringtone = RingtoneManager.getRingtone(
            applicationContext,
            RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        )

        btn_set.setOnClickListener {

            val hr = time_picker.hour
            val mi = time_picker.minute

            timer.scheduleAtFixedRate(timerTask {

                var currentTime = txt_clock.text.toString()
                currentTime = currentTime.replaceRange(5, 8, "")

                if (currentTime.equals(alarmTime())) {
                    ringtone.play()
                } else {
                    ringtone.stop()
                }

            }, 0, 1000)

                alarmSetTime = alarmTime()

                tv_setTo.visibility = View.VISIBLE
                tv_alm_disp.visibility = View.VISIBLE

                tv_setTo.text = "Alarm Set To: "
                tv_alm_disp.text = alarmSetTime
        }


        btn_about.setOnClickListener {



            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, aboutFragment)
                .addToBackStack(aboutFragment.toString())
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit()
        }
    }

    //overide back button for return intent
    override fun onBackPressed() {

        var returnIntent: Intent = Intent()
        returnIntent.putExtra("AlarmSet",alarmSetTime)
        setResult(Activity.RESULT_OK, returnIntent)
        super.onBackPressed()
    }



    /**
     * A private helper function to get the alarm time selected
     * by the time picker.
     *
     * @return returns a string representation of time in 'HH:MM AM/PM' format
     */
    private fun alarmTime(): String {

        val alMin:String;
        var alTime: String;
        var alHours = time_picker.hour

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
            if(alHours < 10){
                alTime = "0"
            }else{
                alTime = ""
            }
            alTime += alHours.toString() + ":" + alMin + " AM"
        }

        //alarmSetTime = alTime
        return alTime
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
