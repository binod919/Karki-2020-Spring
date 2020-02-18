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
        play_button.setOnClickListener {

            val name:String = name_text.text.toString()

            if(name != null){

                //set intent to launch second activity
                val intent: Intent = Intent(this, SecondActivity::class.java)
                startActivityForResult(intent, 10)                                       //launch intent with request code
            }else {
                // TODO: Set hint color to red
            }

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        
    }
}
