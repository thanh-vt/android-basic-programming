package com.thanhvt.todo.worker

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.widget.TextView
import java.lang.ref.WeakReference

/**
 *
 *
 * @created 5/3/2022 - 9:32 AM
 * @project TodoApp
 * @author pysga
 * @since 1.0
 **/
@SuppressLint("SetTextI18n")
@Suppress("OverridingDeprecatedMember", "DEPRECATION")
class TaskWorker(private val statusBannerRef: WeakReference<TextView>) : AsyncTask<Void, String, String>() {

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: Void?): String {
        for (task in 1..5) {
            publishProgress("Finish task $task.\n")
        }
        return "Finish working! \n"
    }


    @Deprecated("Deprecated in Java", ReplaceWith("super.onPreExecute()", "android.os.AsyncTask"))
    override fun onPreExecute() {
        super.onPreExecute()
        this.statusBannerRef.get()?.text = "Progress: \nStart working!\n"
    }

    @Deprecated("Deprecated in Java", ReplaceWith("super.onPostExecute(result)", "android.os.AsyncTask"))
    override fun onPostExecute(result: String?) {
        super.onPostExecute(result)
        this.statusBannerRef.get()?.append(result)
    }

    @Deprecated("Deprecated in Java", ReplaceWith("super.onProgressUpdate(*values)", "android.os.AsyncTask"))
    override fun onProgressUpdate(vararg values: String?) {
        super.onProgressUpdate(*values)
        this.statusBannerRef.get()?.append(values[0])
    }

    @Deprecated("Deprecated in Java", ReplaceWith("super.onCancelled(result)", "android.os.AsyncTask"))
    override fun onCancelled(result: String?) {
        super.onCancelled(result)
    }

    @Deprecated("Deprecated in Java", ReplaceWith("super.onCancelled()", "android.os.AsyncTask"))
    override fun onCancelled() {
        super.onCancelled()
    }
}