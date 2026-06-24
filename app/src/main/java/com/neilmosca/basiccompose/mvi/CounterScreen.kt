package com.neilmosca.basiccompose.mvi

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
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

    CounterContent(
        state = state,
        onIntent = { mainViewModel.handleIntent(it) }
    )
}

@Composable
fun CounterContent(
    state: CounterState,
    onIntent: (CounterIntent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (state.countdownIsRunning) {
            Text(
                text = "Counting Down",
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
            Text(
                text = "${state.count}",
                fontSize = 48.sp,
                style = MaterialTheme.typography.titleLarge
            )
            CircularProgressIndicator(
                modifier = Modifier.size(64.dp),
                color = MaterialTheme.colorScheme.primary,
                trackColor = MaterialTheme.colorScheme.surfaceVariant,
                strokeWidth = 8.dp,
                strokeCap = StrokeCap.Round
            )
        } else {
            Text(
                text = "Click Me Button\n is pressed",
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
            Text(
                text = "${state.count}",
                fontSize = 48.sp,
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "times",
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { onIntent(CounterIntent.Increment) }) {
                Text("Click Me")
            }

            OutlinedButton(onClick = { onIntent(CounterIntent.Reset) }) {
                Text("Reset")
            }

            FilledTonalButton(onClick = { onIntent(CounterIntent.CountdownReset) }) {
                Text("Countdown Reset")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterScreenPreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CounterContent(
                state = CounterState(count = 5),
                onIntent = {}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CounterScreenCountdownIsRunningPreview() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CounterContent(
                state = CounterState(count = 10, countdownIsRunning = true),
                onIntent = {}
            )
        }
    }
}
