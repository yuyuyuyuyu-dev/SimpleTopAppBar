package dev.yuyuyuyuyu.simpletopappbar.example.multiplatform.ui.opensourcelicenses.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun OpenSourceLicensesScreen(
    modifier: Modifier = Modifier,
) = Box(
    modifier = modifier.fillMaxSize(),
    contentAlignment = Alignment.Center,
) {
    Text("OpenSourceLicensesScreen")
}
