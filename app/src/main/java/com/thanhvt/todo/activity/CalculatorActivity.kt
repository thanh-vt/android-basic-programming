package com.thanhvt.todo.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.thanhvt.todo.databinding.ActivityCalculatorBinding

private const val TAG = "CalculatorActivity"

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun doAdd(view: View) {
        Log.d(TAG, "Number 1 = ${binding.number1.text}, Number 2 = ${binding.number2.text}")
        binding.result.text = (binding.number1.text.toString().toLong() + binding.number2.text.toString().toLong()).toString()
    }

    fun doSubtract(view: View) {
        Log.d(TAG, "Number 1 = ${binding.number1.text}, Number 2 = ${binding.number2.text}")
        binding.result.text = (binding.number1.text.toString().toLong() - binding.number2.text.toString().toLong()).toString()
    }
    fun doMultiply(view: View) {
        Log.d(TAG, "Number 1 = ${binding.number1.text}, Number 2 = ${binding.number2.text}")
        binding.result.text = (binding.number1.text.toString().toLong() * binding.number2.text.toString().toLong()).toString()
    }
    fun doDivide(view: View) {
        Log.d(TAG, "Number 1 = ${binding.number1.text}, Number 2 = ${binding.number2.text}")
        binding.result.text = (binding.number1.text.toString().toLong() / binding.number2.text.toString().toLong()).toString()
    }


}