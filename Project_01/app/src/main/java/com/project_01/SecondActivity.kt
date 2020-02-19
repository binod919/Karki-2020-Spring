package com.project_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {


    /**
     * 0 - open spot
     * 1- circle  --computer
     * 2- cross   --player
     */

    var i:IntArray = intArrayOf(0,0,0)
    var j:IntArray = intArrayOf(0,0,0)
    var k:IntArray = intArrayOf(0,0,0)

    var arr: Array<IntArray> = arrayOf(i,j,k);



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // computer goes first and waits for player
        computerMove()



    }

    fun computerMove(){

        var updated = false

        while(!updated){
            val i = (0 until 3).random()
            val j = (0 until 3).random()

            if(arr[i][j] != 0){
                updated = true
                arr[i][j] = 1
            }
        }




    }

}
