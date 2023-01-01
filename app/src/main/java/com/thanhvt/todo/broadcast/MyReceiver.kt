package com.thanhvt.todo.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/**
 *
 *
 * @created 01/01/2023 - 2:07 CH
 * @project demo-app
 * @author pysga
 * @since 1.0
 **/
class MyReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        // This method is called when this BroadcastReceiver receives an Intent broadcast.
        Toast.makeText(context, "Action: " + intent.action, Toast.LENGTH_SHORT).show()
    }
}