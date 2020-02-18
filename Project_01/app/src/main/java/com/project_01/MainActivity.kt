package com.project_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // when this button is clicked, new activity should launch
        click_button.setOnClickListener {

            //set intent to launch second activity
            val intent: Intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, 10)                              //launch intent with request code
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        
    }
}
