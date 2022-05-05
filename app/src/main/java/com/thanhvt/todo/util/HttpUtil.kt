package com.thanhvt.todo.util

import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.util.Log
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


private const val TAG = ""

object HttpUtil {

    @JvmStatic
    fun readAsString(urlStr: String): String {
        val policy = ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        val url = URL(urlStr)
        val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
        val isReader = InputStreamReader(urlConnection.inputStream)
        val bfReader = BufferedReader(isReader)
        val content: StringBuilder = StringBuilder()
        var line: String?
        try {
            do {
                line = bfReader.readLine()
                if (line != null) {
                    content.append(line)
                }
            } while (line != null)
        } catch (ex: Exception) {
            Log.d(TAG, ex.toString())
        }
        return content.toString()
    }
}