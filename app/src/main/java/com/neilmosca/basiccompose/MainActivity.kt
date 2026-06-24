package com.neilmosca.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.neilmosca.basiccompose.mvvm.FruitRepositoryImpl
import com.neilmosca.basiccompose.mvvm.FruitViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fruitRepository = FruitRepositoryImpl()
        val fruitViewModel = FruitViewModel(repository = fruitRepository)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreen(viewModel = fruitViewModel)
                }
            }
        }
    }
}

