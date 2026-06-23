package com.neilmosca.basiccompose.mvi

// MainViewModel.kt
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel : ViewModel() {

    // Internal mutable state (private to the ViewModel)
    private val _uiState = MutableStateFlow(CounterState())

    // External immutable state (read-only for the UI)
    val uiState: StateFlow<CounterState> = _uiState.asStateFlow()

    // Business logic to update state via Intent
    fun handleIntent(intent: CounterIntent) {
        _uiState.update { currentState ->
            when (intent) {
                is CounterIntent.Increment -> currentState.copy(count = currentState.count + 1)
                is CounterIntent.Reset -> currentState.copy(count = 0)
            }
        }
    }
}
