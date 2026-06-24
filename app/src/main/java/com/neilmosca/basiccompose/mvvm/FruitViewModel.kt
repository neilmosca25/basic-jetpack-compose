package com.neilmosca.basiccompose.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.neilmosca.basiccompose.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FruitViewModel(
    val repository: FruitRepository
) : ViewModel() {

    private val _fruits = MutableLiveData<List<Fruit>>()
    val fruits: LiveData<List<Fruit>> get() = _fruits

    init {
        loadFruits()
    }

    private fun loadFruits() {
        _fruits.value = repository.getAllFruits()
    }
}
