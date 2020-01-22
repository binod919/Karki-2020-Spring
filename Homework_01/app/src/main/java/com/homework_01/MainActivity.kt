package com.homework_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        concat_button.setOnClickListener {
            concat_view.text = "Concatenated Strings\n ${input_text_1.text}" + " ${input_text_2.text}"
        }

    }
}
