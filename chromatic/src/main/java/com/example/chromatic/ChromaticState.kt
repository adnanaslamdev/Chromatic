package com.example.chromatic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

data class ChromaticState(
    var hue: Float = 0f,
    var saturation: Float = 1f,
    var brightness: Float = 1f
)

@Composable
fun rememberChromaticState() = remember {
    mutableStateOf(ChromaticState())
}