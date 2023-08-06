package com.dwi.myjetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color.Green),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceBetween
//            ) {
//                Text(text = "Hello")
//                Text(text = "World")
//                Text(text = "Hello")
//            }

            /**
             * when in column use horizontalAlignment and verticalArrangement
             * but in the row horizontalAlignment to horizontalArrangement and verticalArrangement to verticalAlignment
             * so basically they swapped
             **/

            Row(
                modifier = Modifier
//                    .fillMaxSize(0.5f)
                    .width(300.dp)
//                    .height(300.dp)
                    .fillMaxHeight(0.7f)
                    .background(Color.Green),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Hello")
                Text(text = "World")
                Text(text = "Hello")
            }
        }
    }
}