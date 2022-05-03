package com.thanhvt.todo.worker

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.lang.ref.WeakReference
import java.net.URL

/**
 *
 *
 * @created 5/3/2022 - 10:21 AM
 * @project TodoApp
 * @author pysga
 * @since 1.0
 **/
@SuppressLint("SetTextI18n")
@Suppress("OverridingDeprecatedMember", "DEPRECATION")
class ImageWorker (private val imgViewRef : WeakReference<ImageView>) : AsyncTask<String, Void, Bitmap>() {

    @Deprecated("Deprecated in Java")
    override fun doInBackground(vararg params: String?): Bitmap {
        val url = URL(params[0])
        val iS = url.openConnection().getInputStream()
        return BitmapFactory.decodeStream(iS)
    }

    @Deprecated("Deprecated in Java")
    override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)
        imgViewRef.get()?.setImageBitmap(result)
    }
}