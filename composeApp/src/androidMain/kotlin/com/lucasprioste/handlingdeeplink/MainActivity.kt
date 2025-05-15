package com.lucasprioste.handlingdeeplink

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.lucasprioste.handlingdeeplink.presentation.core.navigation.DeepLinkHelper
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val deepLinkHelper: DeepLinkHelper by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App()
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        setIntent(intent)
        intent.dataString?.let { deepLinkHelper.handle(it) }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}