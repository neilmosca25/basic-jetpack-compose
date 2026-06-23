package com.neilmosca.basiccompose.mvvm

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitScreen(
    viewModel: FruitViewModel = viewModel()
) {
    val fruits = viewModel.fruits.observeAsState(emptyList())

    FruitContent(fruits = fruits.value)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FruitContent(fruits: List<Fruit>) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Fruit List") }
            )
        }
    ) { padding ->
        FruitList(
            fruits = fruits,
            modifier = Modifier.padding(padding)
        )
    }
}

@Composable
fun FruitList(
    fruits: List<Fruit>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(fruits) { fruit ->
            FruitItem(fruit = fruit)
        }
    }
}

@Composable
fun FruitItem(fruit: Fruit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Text(
            text = fruit.name,
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FruitScreenPreview() {
    MaterialTheme {
        FruitContent(
            fruits = listOf(
                Fruit("Apple"),
                Fruit("Banana"),
                Fruit("Orange")
            )
        )
    }
}
