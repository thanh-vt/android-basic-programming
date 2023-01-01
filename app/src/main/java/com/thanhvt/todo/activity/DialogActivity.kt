package com.thanhvt.todo.activity

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.thanhvt.todo.R
import com.thanhvt.todo.databinding.ActivityDialogBinding

/**
 *
 *
 * @created 01/01/2023 - 11:32 SA
 * @project demo-app
 * @author pysga
 * @since 1.0
 **/
class DialogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        this.setFinishOnTouchOutside(false)
        binding.btnOk.setOnClickListener {
            finish()
        }
    }
}