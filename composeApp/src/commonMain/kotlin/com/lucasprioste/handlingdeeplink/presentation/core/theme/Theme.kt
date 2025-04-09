package com.lucasprioste.handlingdeeplink.presentation.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    background = White,
    onBackground = ChaosBlack,
    primary = ChaosBlack,
    onPrimary = White,
)

private val LightColorScheme = lightColorScheme(
    background = White,
    onBackground = ChaosBlack,
    primary = ChaosBlack,
    onPrimary = White,
)

@Composable
fun HandlingDeepLinkTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content,
    )
}