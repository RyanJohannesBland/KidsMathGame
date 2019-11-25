package com.example.kidsmathgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var gradeSelector = findViewById<SeekBar>(R.id.gradeSelector)
        var gradeDisplay = findViewById<TextView>(R.id.gradeDisplay)
        var startTestButton = findViewById<Button>(R.id.startTestButton)

        startTestButton.setOnClickListener{
            val intent = Intent(this, testingPage::class.java)
            startActivity(intent)
        }

        gradeSelector.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (progress == 0){
                    gradeDisplay.setText("Preschool")
                }
                else if (progress == 1){
                    gradeDisplay.setText("Kindergarten")
                }
                else{
                    gradeDisplay.setText((seekBar.progress - 1).toString())
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}
