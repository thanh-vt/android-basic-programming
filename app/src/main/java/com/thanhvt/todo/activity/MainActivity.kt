package com.thanhvt.todo.activity

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.thanhvt.todo.databinding.ActivityMainBinding
import com.thanhvt.todo.worker.ImageWorker
import com.thanhvt.todo.worker.TaskWorker
import java.lang.ref.WeakReference


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.handlers = this
        var a: String? = "hello"
        a = null
        var b: String = "world"!!
        val c: String = "Cannot change"
        var d: Int = 10
        var e: Int = 15
        if (d > e) {
            Log.d(TAG, "d > e")
        } else {
            Log.d(TAG, "d < e")
        }
        when (b) {
            "hello" -> {
                Log.d(TAG, "b is hello")
            }
            "world" -> {
                Log.d(TAG, "b is world")
            }
        }
        when (d) {
            in 1..3 -> Log.d(TAG, "Q1")
            in 4..6 -> Log.d(TAG, "Q2")
            in 7..9 -> Log.d(TAG, "Q3")
            else -> Log.d(TAG, "Q4")
        }
        while (e < 20) {
            e--
            if (e < d) break
            Log.d(TAG, "e = $e")
        }
        for (i in 1..10) {
            Log.d(TAG, "i = $i")
        }
        for (j in 0 until d step 2) {
            Log.d(TAG, "j = $j")
        }
        val numbers: IntArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        d = numbers[0]
        val fruits: List<String> = listOf("apple", "banana", "mango", "lemon")
        b = fruits[2]
        val transportations: ArrayList<String> = ArrayList(10)
        transportations.add(0, "mango")
        Log.d(TAG, transportations.toString())
    }

    fun switchToCalculator(view: View) {
        val intent = Intent(this, CalculatorActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, "From main activity to Calculator")
        }
        startActivity(intent)
    }

    fun switchToImage(view: View) {
        val intent = Intent(this, ImageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, "From main activity to Image")
        }
        startActivity(intent)
    }

    fun switchToDishesList(isAdvanced: Boolean) {
        val intent: Intent = if (isAdvanced) {
            Intent(this, AdvancedListviewActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, "From main activity to Advanced Listview")
            }
        } else {
            Intent(this, SimpleListviewActivity::class.java).apply {
                putExtra(EXTRA_MESSAGE, "From main activity to Simple Listview")
            }
        }
        startActivity(intent)
    }

    fun switchToPhotoList(view: View) {
        val intent = Intent(this, RecyclerViewActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, "From main activity to Recycler View")
        }
        startActivity(intent)
    }

    fun switchToWebview(view: View) {
        val intent = Intent(this, WebviewActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, "From main activity to Webview View")
        }
        startActivity(intent)
    }

    fun doWorkInBackground(view: View) {
        TaskWorker(WeakReference(binding.workerStatus))
            .execute()
        ImageWorker(WeakReference(binding.imgWorkerStatus))
            .execute("https://nintendoeverything.com/wp-content/uploads/pokemon-adventures-anniversary.jpg")
    }



}