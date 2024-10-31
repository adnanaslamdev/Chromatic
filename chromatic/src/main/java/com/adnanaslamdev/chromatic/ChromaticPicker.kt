package com.adnanaslamdev.chromatic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@Composable
fun ChromaticPicker(
    modifier: Modifier = Modifier,
    showHue: Boolean = true,
    showSaturation: Boolean = true,
    showBrightness: Boolean = true,
    showColorCode: Boolean = true,
    onColorChange: (Color) -> Unit
) {
    val chromaticState = rememberChromaticState()
    var selectedColor by remember { mutableStateOf(Color.Red) }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        ChromaticHueSlider(
            hue = chromaticState.value.hue,
            onHueChange = { hue ->
                chromaticState.value.hue = hue
                selectedColor = Color.hsv(
                    hue,
                    chromaticState.value.saturation,
                    chromaticState.value.brightness
                )
                onColorChange(selectedColor)
            }
        )
        SaturationBrightnessBox(
            hue = chromaticState.value.hue,
            saturation = chromaticState.value.saturation,
            brightness = chromaticState.value.brightness
        ) { saturation, brightness ->
            chromaticState.value.saturation = saturation
            chromaticState.value.brightness = brightness
            selectedColor = Color.hsv(chromaticState.value.hue, saturation, brightness)
            onColorChange(selectedColor)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .height(40.dp)
                    .width(60.dp)
                    .background(selectedColor, RoundedCornerShape(10.dp))
            )
            if (showHue) {
                Text(
                    text = "H:" + (chromaticState.value.hue).toInt(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                )
            }
            if (showSaturation) {
                Text(
                    text = "S:" + (chromaticState.value.saturation * 100).toInt(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                )
            }
            if (showBrightness) {
                Text(
                    text = "B:" + (chromaticState.value.brightness * 100).toInt(),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                )
            }
            if (showColorCode) {
                Text(
                    text = "#:" + selectedColor.toHex().replace("#", ""),
                    style = TextStyle(
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                )
            }
        }
    }
}

private fun Color.toHex(): String {
    val red = (red * 255).roundToInt()
    val green = (green * 255).roundToInt()
    val blue = (blue * 255).roundToInt()
    val alpha = (alpha * 255).roundToInt()
    return String.format("#%02X%02X%02X%02X", alpha, red, green, blue)
}