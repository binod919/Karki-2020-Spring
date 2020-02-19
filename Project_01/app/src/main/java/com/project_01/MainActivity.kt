package com.project_01

import android.content.Intent
import android.graphics.Color
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

            if(name.isNotEmpty()){

                //set intent to launch second activity
                val intent: Intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("user", name)           // Pass username To second activity
                startActivityForResult(intent, 10)   //launch intent with request code

            }else {

                name_text.setHint("Enter Your Name!!")
                name_text.setHintTextColor(Color.RED)

            }

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        
    }
}
