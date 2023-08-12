package com.dwi.myjetpackcomposebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scope = rememberCoroutineScope()
            val snackbarHostState = remember { SnackbarHostState() }
            var textFieldState by remember {
                mutableStateOf("")
            }
            Scaffold(modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp),
                snackbarHost = {
                    SnackbarHost(hostState = snackbarHostState)
                },
                content = { padding ->
                    Column(
                        modifier = Modifier
                            .padding(padding)
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        OutlinedTextField(
                            value = textFieldState,
                            label = {
                                Text(
                                    "Enter Your Name"
                                )
                            },
                            onValueChange = {
                                textFieldState = it
                            },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth(),
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Button(onClick = {
                                scope.launch {
                                    if (textFieldState.isNotEmpty()) {
                                        val result = snackbarHostState.showSnackbar(
                                            message = "Hello $textFieldState",
                                            actionLabel = "Action",
                                            duration = SnackbarDuration.Short
                                        )

                                        when (result) {
                                            SnackbarResult.ActionPerformed -> {/* Handle snackbar action performed */
                                            }

                                            SnackbarResult.Dismissed -> {
                                                textFieldState = ""
                                            }
                                        }
                                    } else {
                                        snackbarHostState.showSnackbar(
                                            message = "your text field is empty"
                                        )
                                    }
                                }
                            }) {
                                Text(text = "Click Me")
                            }
                        }
                    }
                })
        }
    }
}
