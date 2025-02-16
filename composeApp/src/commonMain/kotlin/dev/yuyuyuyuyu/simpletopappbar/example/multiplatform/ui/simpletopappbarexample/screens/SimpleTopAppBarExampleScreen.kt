package dev.yuyuyuyuyu.simpletopappbar.example.multiplatform.ui.simpletopappbarexample.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.yuyuyuyuyu.simpletopappbar.example.multiplatform.Greeting

@Composable
fun SimpleTopAppBarExampleScreen(
    modifier: Modifier = Modifier,
) = Box(
    modifier = modifier.fillMaxSize(),
    contentAlignment = Alignment.Center,
) {
    Text(Greeting().greet())
}
