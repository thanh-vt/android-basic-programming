package com.thanhvt.todo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var a : String? = "hello"
        a = null
        var b : String = "world"!!
        val c : String = "Cannot change"
        var d : Int = 10
        var e : Int = 15
        if (d > e) {
            Log.d("AAA", "d > e")
        } else {
            Log.d("AAA", "d < e")
        }
        when(b) {
            "hello" -> {
                Log.d("AAA", "b is hello")
            }
            "world" -> {
                Log.d("AAA", "b is world")
            }
        }
        when(d) {
            in 1..3 -> Log.d("AAA","Q1")
            in 4..6 -> Log.d("AAA","Q2")
            in 7..9 -> Log.d("AAA", "Q3")
            else -> Log.d("AAA", "Q4")
        }
        while (e < 20) {
            e--
            if (e < d) break
            Log.d("AAA", "e = $e")
        }
        for (i in 1..10) {
            Log.d("AAA", "i = $i")
        }
        for (j in 0 until d step 2) {
            Log.d("AAA", "j = $j")
        }
        val numbers : IntArray = intArrayOf(1,2,3,4,5,6,7,8,9,10)
        d = numbers[0]
        val fruits : List<String> = listOf("apple", "banana", "mango", "lemon")
        b = fruits[2]
        val transportations : ArrayList<String> = ArrayList(10)
        transportations.add(0, "mango")
        Log.d("AAA", transportations.toString())
    }

    fun goToListview(view: View) {
        val btn = findViewById<Button>(R.id.switchBtn)
        val intent = Intent(this, ActivityListviewDemo::class.java).apply {
            putExtra(EXTRA_MESSAGE, btn.text)
        }
        startActivity(intent)
    }
}