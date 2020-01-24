package com.homework_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * Get the input strings from the edit text, concat them, and display it in text
         * view
         */
        concat_button.setOnClickListener {
            if(input_text_1.text.length >0 || input_text_2.text.length >0) concat_view.text =
                "Concatenated Strings\n ${input_text_1.text}" + " ${input_text_2.text}"
        }


        /**
         * Get the input strings form the edit text, get their reverse string, concat reverse string,
         * and display it in the text view
         */
        add_button.setOnClickListener {
            if(input_text_1.text.length >0 || input_text_2.text.length >0){
                val str_1:String = input_text_1.text.toString()
                val str_2:String = input_text_2.text.toString()

                var rev_str_1: String = getReverseString(str_1)
                val rev_srt_2: String = getReverseString(str_2)

                text_view_2.text = "$rev_str_1 $rev_srt_2"


            }

        }

    }

    /**
     * Get the reverse string
     * @param str1 string to be reversed
     * @return returns the reverse string
     */
    private fun getReverseString(str1: String): String {
        var ret: String = ""

        var i = str1.length - 1

        while(i >= 0){
            ret += str1[i]
            i--
        }

        return ret;

    }

}
