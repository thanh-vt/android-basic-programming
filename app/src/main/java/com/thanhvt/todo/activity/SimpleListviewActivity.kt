package com.thanhvt.todo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.thanhvt.todo.databinding.ActivityCalculatorBinding
import com.thanhvt.todo.databinding.ActivitySimpleListviewBinding

class SimpleListviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySimpleListviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleListviewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val subjects: List<String> = listOf("iOS", "Android", "Windows Phone", "Symbian")
        binding.simpleListView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subjects)
    }
}