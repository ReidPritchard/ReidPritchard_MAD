package com.example.lab_07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    lateinit var coolSwitch: SwitchMaterial
    lateinit var coolGroup: RadioGroup
    lateinit var coolCrank: SeekBar
    lateinit var coolSpinner: Spinner
    lateinit var coolArtist: CheckBox
    lateinit var coolMusic: CheckBox
    lateinit var coolResume: CheckBox
    lateinit var coolButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        coolSwitch = findViewById(R.id.coolSwitch)
        coolGroup = findViewById(R.id.coolGroup)
        coolCrank = findViewById(R.id.coolCrank)
        coolSpinner = findViewById(R.id.coolSpinner)
        coolArtist = findViewById(R.id.coolArtist)
        coolMusic = findViewById(R.id.coolMusician)
        coolResume = findViewById(R.id.coolResume)

        coolButton = findViewById(R.id.checkCoolButton)
        coolButton.setOnClickListener(coolCheck())
    }


    private fun coolCheck(): View.OnClickListener? {
        var score = 0

        if (coolSwitch.isActivated) score + 10
        Log.d("score", score.toString())

        var radioTemp = coolGroup.checkedRadioButtonId()
//        if(coolGroup.getChildAt(radioTemp).getText())

    }
}