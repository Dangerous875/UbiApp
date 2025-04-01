package com.barzabaldevs.ubiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.barzabaldevs.ubiapp.ui.core.NavigationWrapper
import com.barzabaldevs.ubiapp.ui.core.theme.UbiAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UbiAppTheme(darkTheme = true) {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    NavigationWrapper(padding)
                }
            }
        }
    }
}
