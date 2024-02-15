package com.example.alatapp.welcomescreen.presentation.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@Composable
fun AlatRedBackgroundButton(
    modifier: Modifier = Modifier,
    text: String = "",
    onClick: () -> Unit
) {

    val interactionSource = remember {
        MutableInteractionSource()
    }
    var buttonState by remember { mutableStateOf(ButtonState.IDLE) }
    val scale by animateFloatAsState(if (buttonState == ButtonState.IDLE) 0.90f else 1f, label = "")
    val isClicked = interactionSource.collectIsPressedAsState().value

    LaunchedEffect(key1 = isClicked, block = {
        if(isClicked){
            onClick.invoke()
        }
    })


    Button(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, Color.Red),

        modifier = modifier
            .pointerInput(buttonState) {
                awaitPointerEventScope {
                    buttonState = if (buttonState == ButtonState.PRESSED) {
                        waitForUpOrCancellation()
                        ButtonState.IDLE
                    } else {
                        awaitFirstDown(false)
                        ButtonState.PRESSED
                    }
                }
            }
            .fillMaxWidth()
            .padding(vertical = 32.dp, horizontal = 0.dp)
            .height(48.dp)
            .graphicsLayer {
                  scaleX = scale
                scaleY = scale
            },
        interactionSource = interactionSource,
        onClick = {  },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0XFFA90836)
        )
    ) {
        Text(text = text, color = Color.White)
    }


}

enum class ButtonState {PRESSED, IDLE}

