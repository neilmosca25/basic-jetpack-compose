package com.neilmosca.basiccompose.mvi

data class CounterState(
    val count: Int = 0,
    val countdownIsRunning: Boolean = false
)
