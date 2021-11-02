package com.example.lab_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var isPimped = false;
    lateinit var textInput: EditText
    private lateinit var turkeyImage: ImageView
    lateinit var pimpButton: Button
    private lateinit var turkeyText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init variables
        textInput = findViewById<EditText>(R.id.editTextTextPersonName)
        turkeyImage = findViewById<ImageView>(R.id.turkeyView)
        pimpButton = findViewById<Button>(R.id.pimpButton)
        turkeyText = findViewById<TextView>(R.id.turkeyText)

        // Create text change event listener to set button status at every option
        textInput.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                pimpButton.isEnabled = textInput.text.isNotEmpty()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                pimpButton.isEnabled = textInput.text.isNotEmpty()
            }

            override fun afterTextChanged(s: Editable?) {
                pimpButton.isEnabled = textInput.text.isNotEmpty()
            }

        })
    }

    fun pimpThatTurkey(v: View) {
        if (!isPimped) {
            turkeyImage.setImageResource(R.drawable.pimped_turkey)
            turkeyText.text = getString(R.string.pimpedTurkeyText, textInput.text)
            pimpButton.text = getString(R.string.turkeyUnPimpButton)

            isPimped = true
        } else {
            turkeyImage.setImageResource(R.drawable.turkey)
            turkeyText.text = ""
            pimpButton.text = getString(R.string.turkeyPimpButton)

            isPimped = false
        }
    }

}