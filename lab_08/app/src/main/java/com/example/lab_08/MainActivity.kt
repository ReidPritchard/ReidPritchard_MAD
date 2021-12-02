package com.example.lab_08

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.switchmaterial.SwitchMaterial

class MainActivity : AppCompatActivity() {
    private val coffeeShopManager: DataClass = DataClass(true)

    private lateinit var shouldShowCoffeeButton: ToggleButton
    private lateinit var localSwitch: SwitchMaterial
    private lateinit var coffeeButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get view elements
        shouldShowCoffeeButton = findViewById(R.id.coffeeToggle)
        localSwitch = findViewById(R.id.localSwitch)
        coffeeButton = findViewById(R.id.goCoffeeButton)

        // Set event listeners
        coffeeButton.setOnClickListener {
            handleGoCoffee(it)
        }
    }


    private fun handleGoCoffee(v: View) {
        // Create intent based on toggles
        Log.d("HandleGo", localSwitch.isEnabled.toString())
        Log.d("HandleGo", shouldShowCoffeeButton.isActivated.toString())

        val coffeeShop: List<Any>?;

        // I would do this better, but I'm drowning in work
        coffeeShop = if (shouldShowCoffeeButton.isChecked) {
            if (localSwitch.isChecked) {
                coffeeShopManager.getShop("Amante")
            } else {
                coffeeShopManager.getShop("Starbucks")
            }
        } else {
            coffeeShopManager.getShop("No Coffee????")
        }

        handleDetailNavigation(v, coffeeShop)
    }


    private fun handleDetailNavigation(v: View, coffeeShop: List<Any>?) {
        // Explicit intent
        coffeeShop?.let {
            val intent = Intent(this, CoffeeDetail::class.java).apply {
                putExtra("shopName", it[0].toString())
                putExtra("imgName", it[1].toString())
                putExtra("isLocal", it[2] as Boolean)
                putExtra("address", it[3].toString())
            }

            startActivity(intent)
        }
    }
}