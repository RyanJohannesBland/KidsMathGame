package com.example.kidsmathgame

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

import kotlinx.android.synthetic.main.activity_testing_page.*
import java.util.*
import kotlin.concurrent.timerTask

class testingPage : AppCompatActivity() {

    var answer: String?=null
    val layout: ConstraintLayout = findViewById<ConstraintLayout>(R.id.coordinatorLayout)
    var questionDisplay: TextView = findViewById<TextView>(R.id.gradeDisplay)
    var bubbles:ArrayList<Button>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing_page)

        var question = getQuestion()

        while(true){
            Timer().schedule(timerTask { bubbles?.add(getBubble())}, 2000)
        }

    }

    fun getQuestion(): String{

        val randomNumberA = Math.floor(Math.random() * 5)
        val randomNumberB = Math.floor(Math.random() * 5)

        val questionText = randomNumberA.toString() + "+" + randomNumberB.toString()
        this.answer = (randomNumberA.toInt() + randomNumberB.toInt()).toString()
        return questionText

    }

    fun getBubble(): Button{


        val bubble = Button(this)

        bubble.setText((Math.random() * 10).toInt())
        bubble.x = (Math.random() * 10).toFloat()
        bubble.y = (Math.random() * 10).toFloat()
        bubble.setOnClickListener{
            
            if(bubble.text == answer){
                getQuestion()
            }
            layout.removeView(bubble)
        }

        layout.addView(bubble)

        return bubble
    }
}
