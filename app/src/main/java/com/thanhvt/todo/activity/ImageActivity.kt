package com.thanhvt.todo.activity

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.thanhvt.todo.R

private const val TAG = "ImageActivity"

class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_image)
        // demo for compose
        Log.d(TAG, "Demo using compose")
        setContent {
            ImageFrame()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ImageFrame() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        val imgModifier = Modifier
            .width(300.dp)
            .height(250.dp)
        GifImage(
            imageID = R.drawable.test_image,
            modifier = imgModifier
        )
        Column {
            Text(text = "Anime", color = Color.Yellow)
            Text(
                "Test class",
                modifier = Modifier.wrapContentHeight(),
                color = Color.Green,
                fontSize = 12.sp
            )
        }

    }
}

@Composable
fun GifImage(
    modifier: Modifier = Modifier,
    imageID: Int = R.drawable.test_image
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    Image(
        painter = rememberAsyncImagePainter(
            model = imageID,
            imageLoader = imageLoader
        ),
        contentDescription = "Wood",
        contentScale = ContentScale.Fit,
        modifier = modifier
    )
}