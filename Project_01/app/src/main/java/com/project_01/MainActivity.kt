package com.project_01

import android.app.Activity
import android.app.AlertDialog
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

        exit_button.setOnClickListener {
            finish()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var msg: String = ""
        if(data != null){
            if(resultCode == Activity.RESULT_OK){

                var computerWon:Boolean = data.getBooleanExtra("computerWon", false)
                var playerWon:Boolean = data.getBooleanExtra("playerWon", false)

                if(computerWon)
                    msg = "Computer Win the game"
                if(playerWon) msg= "You win the game"

            }else if(resultCode == Activity.RESULT_CANCELED){
                msg = "You quit in the middle"
            }

          val builder = AlertDialog.Builder(this)
            builder.setTitle("")
            builder.setMessage(msg)
            builder.setPositiveButton("OK") { dialog, which ->

            }

            val dialog: AlertDialog = builder.create()
            dialog.show()

        }
    }
}
