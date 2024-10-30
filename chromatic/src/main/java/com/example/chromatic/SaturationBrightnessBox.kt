package com.example.chromatic

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun SaturationBrightnessBox(
    hue: Float,
    saturation: Float,
    brightness: Float,
    onChange: (Float, Float) -> Unit
) {
    val color = Color.hsv(hue = hue, 1f, 1f)

    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .pointerInput(Unit) {
                detectDragGestures { change, _ ->
                    val x = (change.position.x / size.width).coerceIn(0f, 1f)
                    val y = 1f - (change.position.y / size.height).coerceIn(0f, 1f)
                    onChange(x, y)
                }
            }
    ) {
        drawRect(
            brush = Brush.horizontalGradient(listOf(Color.White, color))
        )
        drawRect(
            brush = Brush.verticalGradient(listOf(Color.Transparent, Color.Black))
        )
        val circleX = size.width * saturation
        val circleY = size.height * (1f - brightness)
        drawCircle(
            color = Color.White,
            radius = 30f,
            center = Offset(circleX, circleY),
            style = Stroke(width = 4f)
        )
    }

}