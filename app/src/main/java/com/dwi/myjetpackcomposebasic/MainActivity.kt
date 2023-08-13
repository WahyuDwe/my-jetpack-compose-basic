package com.dwi.myjetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var sizeState by remember {
                mutableStateOf(200.dp)
            }
            val size by animateDpAsState(
                targetValue = sizeState,
//                tween(
//                    durationMillis = 3000,
//                    delayMillis = 300,
//                    easing = LinearOutSlowInEasing
//                ),
//                spring(
//                    Spring.DampingRatioHighBouncy
//                ),
//                keyframes {
//                    durationMillis = 5000
//                    sizeState at 0 with LinearEasing
//                    sizeState * 1.5f at 1000 with FastOutLinearInEasing
//                    sizeState * 2f at 5000
//                },
                tween(
                    durationMillis = 1000
                ),
                label = "size animation"
            )
            val infiniteTransition = rememberInfiniteTransition(label = "")
            val color by infiniteTransition.animateColor(
                initialValue = Color.Red,
                targetValue = Color.Green,
                animationSpec = infiniteRepeatable(
                    tween(
                        durationMillis = 2000
                    ),
                    repeatMode = RepeatMode.Reverse,
                ), label = "infinite size animation"
            )
            Box(modifier = Modifier
                .size(size)
                .background(color),
                contentAlignment = Alignment.Center) {
                Button(onClick = {
                    sizeState += 50.dp
                }) {
                    Text(
                        "Increase Size"
                    )
                }
            }

        }
    }
}
