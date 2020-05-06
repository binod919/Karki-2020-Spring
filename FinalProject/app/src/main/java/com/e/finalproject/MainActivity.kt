package com.e.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var alarmStatus: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(alarmStatus != null){
            alm_stat.visibility = View.VISIBLE
            alm_stat_disp.visibility = View.VISIBLE
            alm_stat_disp.setText(alarmStatus)
        }

        btn_set_alarm.setOnClickListener {

            val intent: Intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, 10)

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(data != null){
            alarmStatus = data.getStringExtra("AlarmSet")
            if(alarmStatus != null) {
                alm_stat.visibility = View.VISIBLE
                alm_stat_disp.visibility = View.VISIBLE
                alm_stat_disp.setText(alarmStatus)
            }
        }

    }
}
