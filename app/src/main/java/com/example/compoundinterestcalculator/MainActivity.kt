package com.example.compoundinterestcalculator

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ln
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.solveForSpinner)
        val finalAmountInput = findViewById<EditText>(R.id.finalAmount)
        val principalInput = findViewById<EditText>(R.id.principal)
        val rateInput = findViewById<EditText>(R.id.rate)
        val timeInput = findViewById<EditText>(R.id.time)
        val compoundInput = findViewById<EditText>(R.id.compound)
        val button = findViewById<Button>(R.id.calculateBtn)
        val resultText = findViewById<TextView>(R.id.result)

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Show all first
                finalAmountInput.visibility = View.VISIBLE
                principalInput.visibility = View.VISIBLE
                rateInput.visibility = View.VISIBLE
                timeInput.visibility = View.VISIBLE
                
                // Hide the one we are solving for
                when (position) {
                    0 -> finalAmountInput.visibility = View.GONE // Solve for A
                    1 -> principalInput.visibility = View.GONE    // Solve for P
                    2 -> rateInput.visibility = View.GONE         // Solve for r
                    3 -> timeInput.visibility = View.GONE         // Solve for t
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        button.setOnClickListener {
            try {
                if (compoundInput.text.isEmpty()) {
                    resultText.text = getString(R.string.error_invalid_input)
                    return@setOnClickListener
                }
                val n = compoundInput.text.toString().toDouble()
                if (n <= 0) {
                    resultText.text = getString(R.string.error_compound_zero)
                    return@setOnClickListener
                }
                
                val solveFor = spinner.selectedItemPosition

                when (solveFor) {
                    0 -> { // Final Amount (A)
                        val p = principalInput.text.toString().toDouble()
                        val r = rateInput.text.toString().toDouble() / 100
                        val t = timeInput.text.toString().toDouble()
                        val a = p * (1 + r / n).pow(n * t)
                        resultText.text = getString(R.string.calculation_result_a, a, p, r, n, n * t, a)
                    }
                    1 -> { // Principal (P)
                        val a = finalAmountInput.text.toString().toDouble()
                        val r = rateInput.text.toString().toDouble() / 100
                        val t = timeInput.text.toString().toDouble()
                        val p = a / (1 + r / n).pow(n * t)
                        resultText.text = getString(R.string.calculation_result_p, p, a, r, n, n * t, p)
                    }
                    2 -> { // Rate (r)
                        val a = finalAmountInput.text.toString().toDouble()
                        val p = principalInput.text.toString().toDouble()
                        val t = timeInput.text.toString().toDouble()
                        if (p == 0.0 || n * t == 0.0) throw Exception()
                        val rValue = n * ((a / p).pow(1.0 / (n * t)) - 1)
                        resultText.text = getString(R.string.calculation_result_r, rValue * 100, n, a, p, n * t, rValue, rValue * 100)
                    }
                    3 -> { // Time (t)
                        val a = finalAmountInput.text.toString().toDouble()
                        val p = principalInput.text.toString().toDouble()
                        val rValue = rateInput.text.toString().toDouble() / 100
                        if (p == 0.0 || (1 + rValue / n) <= 0.0 || (a / p) <= 0.0) throw Exception()
                        val tResult = ln(a / p) / (n * ln(1 + rValue / n))
                        resultText.text = getString(R.string.calculation_result_t, tResult, a, p, n, rValue, n, tResult)
                    }
                }
            } catch (_: Exception) {
                resultText.text = getString(R.string.error_invalid_input)
            }
        }
    }
}