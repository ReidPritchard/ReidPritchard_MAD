package com.example.lab_07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
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
    lateinit var scoreView: TextView
    var score = 0

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
        coolButton.setOnClickListener {
           coolCheck(it)
        }

        scoreView = findViewById(R.id.scoreViewer)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("score", score)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        score = savedInstanceState.getInt("score")
        scoreView.text = score.toString()
    }

    private fun coolCheck(v: View) {
        score = 0

        if (coolSwitch.isChecked) score += 10
//        Log.d("score", score.toString())

        // Get radio button
        val idx = coolGroup.checkedRadioButtonId
        if (idx != -1) {
            val radioTemp: View = coolGroup.findViewById(idx)
            val index = coolGroup.indexOfChild(radioTemp)
            val selected: RadioButton = coolGroup.getChildAt(index) as RadioButton

            // Check radio button selection
            if (selected.text.toString() == resources.getString(R.string.Cool)) score += 2
            if (selected.text.toString() == resources.getString(R.string.Cooool)) score += 6
            if (selected.text.toString() == resources.getString(R.string.Cooooool)) score += 20
        } else {
            score -= 10
        }

        score += coolCrank.progress * 10

        // Get spinner values and selection
        val spinnerPos = coolSpinner.selectedItemPosition
        val spinnerValues = resources.getStringArray(R.array.coolestPickValues)

        score += spinnerValues[spinnerPos].toInt()

        // Check boxes
        if (coolArtist.isChecked) score += 10
        if (coolMusic.isChecked) score += 5
        if (coolResume.isChecked) score += 100

        scoreView.text = score.toString()
    }
}