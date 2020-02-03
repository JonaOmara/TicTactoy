package com.app.invitech.tictactoy

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }//a general function for the buttons identifying them by id

    fun buClick(view: View) {

        val buSelected = view as Button
        var cellID = 0
        when (buSelected.id) {
            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9
        }

        playGame(cellID, buSelected)//calling functions to be performed when button is clicked
        getWiner()

    }


    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var Activeplayer = 1
    //function to play game
    fun playGame(cellID: Int, buSelected: Button) {

        if (Activeplayer == 1) {//making the player interchanges
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            Activeplayer = 2
            Autoplay()

        } else {
            buSelected.text = "0"
            buSelected.setBackgroundColor(Color.BLUE)
            player2.add(cellID)
            Activeplayer = 1
        }
        buSelected.isEnabled = false//disabling the button not to be pressed again
    }

    fun getWiner() {//determining the winer
        var winer = -1
        //rows
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1
        }
        //rows
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1
        }
        //rows
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2
        }
        //rows
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2
        }
        //rows
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2
        }
        //columns
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winer = 2
        }
        if (winer != -1) {
            if (winer == 1) {
                Toast.makeText(this, "Player  wins", Toast.LENGTH_LONG).show()

            }
            if (winer == 2) {
                Toast.makeText(this, "Computer wins", Toast.LENGTH_LONG).show()
            }
        }

    }
          val emptycells = ArrayList<Int>()
    fun Autoplay() {

        for (cellID in 1..9) {
            if (!(player1.contains(cellID)||(player2.contains(cellID)))) {
                emptycells.add(cellID)
            }
        }
        val r= Random()
        val randIndex = r.nextInt(emptycells.size-0)+0
        val  cellID = emptycells[randIndex]
        val buSelect:Button?

        when(cellID){

            1-> buSelect=bu1
            2-> buSelect=bu2
            3-> buSelect=bu3
            4-> buSelect=bu4
            5-> buSelect=bu5
            6-> buSelect=bu6
            7-> buSelect=bu7
            8-> buSelect=bu8
            9-> buSelect=bu9
            else->{
                buSelect=bu1
            }
        }
playGame(cellID,buSelect)
    }
}

