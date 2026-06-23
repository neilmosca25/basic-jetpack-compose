package com.neilmosca.basiccompose.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FruitViewModel : ViewModel() {

    private val _fruits = MutableLiveData<List<Fruit>>()
    val fruits: LiveData<List<Fruit>> get() = _fruits

    init {
        loadFruits()
    }

    private fun loadFruits() {
        _fruits.value = listOf(
                Fruit("Apple"),
                Fruit("Banana"),
                Fruit("Cherry"),
                Fruit("Dragonfruit"),
                Fruit("Elderberry")
            )

    }
}
