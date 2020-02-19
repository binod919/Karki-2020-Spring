package com.project_01

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    /**
     * 0 - open spot
     * 1- circle  --computer
     * 2- cross   --player
     */

    var i: IntArray = intArrayOf(0, 0, 0)
    var j: IntArray = intArrayOf(0, 0, 0)
    var k: IntArray = intArrayOf(0, 0, 0)

    var arr: Array<IntArray> = arrayOf(i, j, k)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        UserData.userName = intent.getStringExtra("user").toString()

        title_txtView.setText(UserData.userName)


        // computer goes first and waits for player
        computerMove()

        btn_00.setOnClickListener {
            arr[0][0] = 2
            btn_00.setText("X")
            btn_00.setEnabled(false)

            UserData.gameFinished = checkGameStatus()

            computerMove()      //Computer puts circle after player
        }

        btn_01.setOnClickListener {
            arr[0][1] = 2
            btn_01.setText("X")
            btn_01.setEnabled(false)

            UserData.gameFinished = checkGameStatus()

            computerMove()      //Computer puts circle after player
        }

        btn_02.setOnClickListener {
            arr[0][2] = 2
            btn_02.setText("X")
            btn_02.setEnabled(false)

            UserData.gameFinished = checkGameStatus()

            computerMove()      //Computer puts circle after player
        }

        btn_10.setOnClickListener {
            arr[1][0] = 2
            btn_10.setText("X")
            btn_10.setEnabled(false)

            UserData.gameFinished = checkGameStatus()

            computerMove()      //Computer puts circle after player
        }

        btn_11.setOnClickListener {
            arr[1][1] = 2
            btn_11.setText("X")
            btn_11.setEnabled(false)

            UserData.gameFinished = checkGameStatus()

            computerMove()      //Computer puts circle after player
        }

        btn_12.setOnClickListener {
            arr[1][2] = 2
            btn_12.setText("X")
            btn_12.setEnabled(false)

            UserData.gameFinished = checkGameStatus()

            computerMove()      //Computer puts circle after player
        }

        btn_20.setOnClickListener {
            arr[2][0] = 2
            btn_20.setText("X")
            btn_20.setEnabled(false)

            UserData.gameFinished = checkGameStatus()

            computerMove()      //Computer puts circle after player
        }

        btn_21.setOnClickListener {
            arr[2][1] = 2
            btn_21.setText("X")
            btn_21.setEnabled(false)

            UserData.gameFinished = checkGameStatus()

            computerMove()      //Computer puts circle after player
        }

        btn_22.setOnClickListener {
            arr[2][2] = 2
            btn_22.setText("X")
            btn_22.setEnabled(false)

            UserData.gameFinished = checkGameStatus()

            computerMove()      //Computer puts circle after player
        }


        /**
         * Reset the game
         */
        restart_button.setOnClickListener {

            /**
             * reset button texts and array
             */
            for (i in 0..2) {
                for (j in 0..2) {
                    val btn = getButton(i, j)
                    arr[i][j] = 0
                    btn!!.setText("--")
                    btn.setEnabled(true);
                }
            }

            computerMove()  //Computer always makes the first move
        }


        /**
         * Keeps tracks whether user won and quit, or quit in the middle of the game
         */
        quit_btn.setOnClickListener {

            if (UserData.gameFinished) {
                setResult(Activity.RESULT_OK)
            } else {
                setResult(Activity.RESULT_CANCELED)
            }

        }

    }


    private fun checkGameStatus(): Boolean{
        return checkRowWin() || checkColumnWin() || checkDiagonalWin()
    }

    /**
     * check diagonals for win
     */
    private fun checkDiagonalWin(): Boolean {

        if(check(arr[0][0], arr[1][1], arr[2][2])){

            highlightButtons(getButton(0,0), getButton(1,1), getButton(2,2))
            return true;

        } else if(check(arr[0][2], arr[1][1], arr[2][0])){
            highlightButtons(getButton(0,2), getButton(1,1), getButton(2,0))
            return true
            }else
                return false
    }

    private fun highlightButtons(button: Button?, button1: Button?, button2: Button?) {

        button!!.setBackgroundColor(Color.GREEN)
        button1!!.setBackgroundColor(Color.GREEN)
        button2!!.setBackgroundColor(Color.GREEN)

    }

    /**
     * check in columns for win
     */
    private fun checkColumnWin(): Boolean {

        for(i in 0..2){
            if(check(arr[0][i],arr[1][i],arr[2][i])){
                highlightButtons(getButton(0,i), getButton(1,i), getButton(2,i))
                return true
            }
        }

        return false
    }

    /**
     * check rows for win
     */
    private fun checkRowWin(): Boolean {
        for(i in 0..2){
            if(check(arr[i][0],arr[i][1],arr[i][2])){
                highlightButtons(getButton(i,0), getButton(i,1), getButton(i,2))
                return true
            }
        }

        return false;
    }

    /**
     * Check if three elements are equal
     */
    private fun check( a: Int, b:Int, c:Int): Boolean{
        return (a != 0) && (a == b) && b == c
    }


    /**
     * Computer marks an open location
     *
     */
    private fun computerMove() {

        var updated = false

        while (!updated) {
            val i = (0 until 3).random()
            val j = (0 until 3).random()

            if (arr[i][j] == 0) {
                updated = true
                arr[i][j] = 1

                val btn: Button? = getButton(i, j)
                btn!!.setText("O")
                btn!!.setEnabled(false)
                UserData.gameFinished = checkGameStatus()
            }
        }

        //TODO: break when game is finished


    }

    /**
     * get button corresponding to matrix
     */
    private fun getButton(i: Int, j: Int): Button? {

        if (i == 0 && j == 0) return btn_00
        if (i == 0 && j == 1) return btn_01
        if (i == 0 && j == 2) return btn_02
        if (i == 1 && j == 0) return btn_10
        if (i == 1 && j == 1) return btn_11
        if (i == 1 && j == 2) return btn_12
        if (i == 2 && j == 0) return btn_20
        if (i == 2 && j == 1) return btn_21
        if (i == 2 && j == 2) return btn_22

        return null
    }

}
