package com.neilmosca.basiccompose

// MainViewModel.kt
import androidx.compose.animation.core.copy
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {

    // Internal mutable state (private to the ViewModel)
    private val _uiState = MutableStateFlow(CounterState())

    // External immutable state (read-only for the UI)
    val uiState: StateFlow<CounterState> = _uiState.asStateFlow()

    // Business logic to update state
    fun onIncrementClicked() {
        _uiState.update { currentState ->
            currentState.copy(count = currentState.count + 1)
        }
    }

    fun onResetClicked() {
        _uiState.update { currentState ->
            currentState.copy(count = 0)
        }
    }
}