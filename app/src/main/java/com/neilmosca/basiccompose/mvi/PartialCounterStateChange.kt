package com.neilmosca.basiccompose.mvi

sealed class PartialCounterStateChange {
    data class Tick(val countLeft: Int) : PartialCounterStateChange()
    data class StatusChanged(val isRunning: Boolean) : PartialCounterStateChange()
    object Finished : PartialCounterStateChange()
}