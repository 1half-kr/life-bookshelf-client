package com.tdd.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import com.tdd.bookshelf.core.designsystem.Gray50
import com.tdd.bookshelf.data.dataStore.createDataStore
import com.tdd.bookshelf.feature.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        setContent {
            val statusBarColor = Gray50.toArgb()
            window.statusBarColor = statusBarColor

            MainScreen(
                dataStore = remember {
                    createDataStore(applicationContext)
                }
            )
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}