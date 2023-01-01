package com.thanhvt.todo.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.AlarmClock
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
        Log.d(TAG, "Create Calculator")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Start Calculator")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Resume Calculator")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Pause Calculator")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Stop Calculator")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Destroy Calculator")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "Restore Calculator")
        binding.number1.setText(savedInstanceState.getString("first_num"))
        binding.number2.setText(savedInstanceState.getString("second_num"))
        binding.result.text = savedInstanceState.getString("result")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "Save Calculator")
        outState.putString("first_num", binding.number1.text.toString())
        outState.putString("second_num", binding.number2.text.toString())
        outState.putString("result", binding.result.text.toString())
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

    fun confirmStartGame(view: View) {
//        val newFragment = StartGameDialogFragment()
//        newFragment.show(supportFragmentManager, "game")
        val intent = Intent(this, DialogActivity::class.java).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, "From Calculator activity to Dialog activity")
        }
        startActivity(intent)
    }
}