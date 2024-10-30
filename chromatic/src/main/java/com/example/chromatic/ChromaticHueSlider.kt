package com.example.chromatic

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChromaticHueSlider(
    hue: Float,
    onHueChange: (Float) -> Unit
) {

    Slider(
        value = hue,
        onValueChange = onHueChange,
        valueRange = 0f..360f,
        thumb = {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(
                        color = Color.hsl(hue = hue, saturation = 1f, lightness = 0.5f),
                        shape = CircleShape
                    )
                    .border(width = 1.dp, color = Color.White, shape = CircleShape)
            )
        },
        track = {
            Box(modifier = Modifier.fillMaxWidth()) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterStart)
                        .height(30.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Red,
                                    Color.Yellow,
                                    Color.Green,
                                    Color.Cyan,
                                    Color.Blue,
                                    Color.Magenta,
                                    Color.Red
                                ),
                                tileMode = TileMode.Clamp
                            )
                        )
                )
            }
        }
    )

}