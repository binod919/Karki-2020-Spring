package com.project_01

import java.io.Serializable

object UserData :Serializable {
    lateinit var userName: String
    var wonCount: Int = 0
    var lostCount: Int = 0
    var gameFinished: Boolean = false
}