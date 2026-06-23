package com.neilmosca.basiccompose.mvi

sealed class CounterIntent {
    data object Increment : CounterIntent()
    data object Reset : CounterIntent()
}
