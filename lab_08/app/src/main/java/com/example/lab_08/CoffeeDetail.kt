package com.example.lab_08

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CoffeeDetail : AppCompatActivity() {
    // Data
    private var shopName: String? = null
    private var imgName: String? = null
    private var isLocal: Boolean? = null
    private var address: String? = null

    // View
    lateinit var shopNameText: TextView
    lateinit var shopImage: ImageView
    lateinit var backButton: Button
    lateinit var directMeButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coffee_detail)

        // Get View Elements
        shopNameText = findViewById(R.id.shopName)
        shopImage = findViewById(R.id.shopImage)
        backButton = findViewById(R.id.backButton)
        directMeButton = findViewById(R.id.takeMeButton)

        // Get intent items
        shopName = intent.getStringExtra("shopName")
        imgName = intent.getStringExtra("imgName")
        isLocal = intent.getBooleanExtra("isLocal", false)
        address = intent.getStringExtra("address")

        // If we got intent items set them in the view
        shopName?.let { shopNameText.text = it }
        imgName?.let {
//            Log.d("img", it)
//            Log.d("img",
//                resources.getIdentifier(
//                    imgName, "drawable",
//                    "drawable"
//                ).toString()
//            )
//
            shopImage.setImageResource(
                resources.getIdentifier(
                    imgName, "drawable",
                    this.packageName
                )
            )
        }
        address?.let {
            directMeButton.isEnabled = it.isNotBlank()
        }
        // Probably should add a place for the address

        // Set click listeners
        backButton.setOnClickListener {
            handleBackClick(it)
        }
        directMeButton.setOnClickListener {
            handleNavigateClick(it)
        }
    }

    private fun handleNavigateClick(v: View) {
        // Implicit intent
        var intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = address?.let {
            // In theory this will open navigation to the coffee shop
            Uri.parse("google.navigation:q=an+${it}+Boulder")
        }

        startActivity(intent)
    }

    private fun handleBackClick(v: View) {
        // Just a boring back button
        super.onBackPressed()
    }

}