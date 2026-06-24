package com.neilmosca.basiccompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.neilmosca.basiccompose.mvi.CounterScreen
import com.neilmosca.basiccompose.mvvm.FruitRepositoryImpl
import com.neilmosca.basiccompose.mvvm.FruitScreen
import com.neilmosca.basiccompose.mvvm.FruitViewModel

@Composable
fun MainScreen(
    viewModel: FruitViewModel
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Counter (MVI)", "Fruits (MVVM)")

    Scaffold(
        topBar = {
            TabRow(selectedTabIndex = selectedTab) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(title) }
                    )
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when (selectedTab) {
                0 -> CounterScreen()
                1 -> FruitScreen(viewModel = viewModel)
            }
        }
    }
}
