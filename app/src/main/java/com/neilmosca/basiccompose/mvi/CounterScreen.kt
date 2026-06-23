package com.neilmosca.basiccompose.mvi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CounterScreen(
    mainViewModel: CounterViewModel = viewModel()
) {
    // Collect StateFlow into a Compose State
    val state by mainViewModel.uiState.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Button pressed: ${state.count} times",
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { mainViewModel.handleIntent(CounterIntent.Increment) }) {
            Text("Click Me")
        }

        OutlinedButton(onClick = { mainViewModel.handleIntent(CounterIntent.Reset) }) {
            Text("Reset")
        }
    }
}

@Preview
@Composable
fun CounterScreenPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        CounterScreen()
    }
}