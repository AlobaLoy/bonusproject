package com.example.compoundinterestcalculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val principal = findViewById<EditText>(R.id.principal)
        val rate = findViewById<EditText>(R.id.rate)
        val time = findViewById<EditText>(R.id.time)
        val compound = findViewById<EditText>(R.id.compound)
        val button = findViewById<Button>(R.id.calculateBtn)
        val result = findViewById<TextView>(R.id.result)

        button.setOnClickListener {
            try {
                val principalValue = principal.text.toString().toDouble()
                val interestRate = rate.text.toString().toDouble() / 100
                val timePeriod = time.text.toString().toDouble()
                val compoundsPerYear = compound.text.toString().toDouble()

                val finalAmount = principalValue * (1 + interestRate / compoundsPerYear).pow(compoundsPerYear * timePeriod)

                result.text = getString(
                    R.string.calculation_result,
                    finalAmount,
                    principalValue,
                    interestRate,
                    compoundsPerYear,
                    compoundsPerYear * timePeriod,
                    finalAmount
                )

            } catch (_: Exception) {
                result.text = getString(R.string.error_invalid_input)
            }
        }
    }
}