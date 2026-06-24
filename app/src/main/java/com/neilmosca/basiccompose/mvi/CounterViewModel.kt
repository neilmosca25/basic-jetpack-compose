package com.neilmosca.basiccompose.mvi

// MainViewModel.kt
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {

    // Internal mutable state (private to the ViewModel)
    private val _uiState = MutableStateFlow(CounterState())

    // External immutable state (read-only for the UI)
    val uiState: StateFlow<CounterState> = _uiState.asStateFlow()

    private var timerJob: Job? = null

    // Business logic to update state via Intent
    fun handleIntent(intent: CounterIntent) {

            when (intent) {
                is CounterIntent.Increment -> {
                    _uiState.update { currentState ->
                        currentState.copy(count = currentState.count + 1)
                    }
                }
                is CounterIntent.Reset -> {
                    _uiState.update { currentState ->
                        currentState.copy(count = 0)
                    }
                }
                is CounterIntent.CountdownReset -> {
                    startCountdownReset()
                }
            }
    }

    private fun startCountdownReset() {
        if (_uiState.value.countdownIsRunning
            || _uiState.value.count < 1) return

        // Emit that the timer has started running
        reduce(PartialCounterStateChange.StatusChanged(isRunning = true))

        timerJob = viewModelScope.launch {
            while (_uiState.value.count > 0) {
                delay(1000L) // Wait exactly one second
                val newCount = _uiState.value.count - 1

                if (newCount == 0) {
                    reduce(PartialCounterStateChange.Finished)
                } else {
                    reduce(PartialCounterStateChange.Tick(newCount))
                }
            }
        }
    }

    // Pure reducer function to compute the state deterministically
    private fun reduce(change: PartialCounterStateChange) {
        _uiState.value = when (change) {
            is PartialCounterStateChange.Tick -> _uiState.value.copy(
                count = change.countLeft
            )
            is PartialCounterStateChange.StatusChanged -> _uiState.value.copy(
                countdownIsRunning = change.isRunning
            )
            PartialCounterStateChange.Finished -> _uiState.value.copy(
                count = 0,
                countdownIsRunning = false
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel() // Avoid memory or coroutine leaks
    }
}
