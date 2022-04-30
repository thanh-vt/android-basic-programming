package com.thanhvt.todo

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }

    fun doAdd(view: View) {
        Log.d("Calculator", "Number 1 = ${number_1.text}, Number 2 = ${number_2.text}")
        result.text = (number_1.text.toString().toLong() + number_2.text.toString().toLong()).toString()
    }

    fun doSubtract(view: View) {
        Log.d("Calculator", "Number 1 = ${number_1.text}, Number 2 = ${number_2.text}")
        result.text = (number_1.text.toString().toLong() - number_2.text.toString().toLong()).toString()
    }
    fun doMultiply(view: View) {
        Log.d("Calculator", "Number 1 = ${number_1.text}, Number 2 = ${number_2.text}")
        result.text = (number_1.text.toString().toLong() * number_2.text.toString().toLong()).toString()
    }
    fun doDivide(view: View) {
        Log.d("Calculator", "Number 1 = ${number_1.text}, Number 2 = ${number_2.text}")
        result.text = (number_1.text.toString().toLong() / number_2.text.toString().toLong()).toString()
    }


}