package com.neilmosca.basiccompose.mvvm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.neilmosca.basiccompose.R

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
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .height(110.dp)
                .padding(10.dp)
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .size(80.dp)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = fruit.imageResId),
                contentDescription = fruit.name
            )
            Spacer(
                modifier = Modifier.width(10.dp)
            )
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically),
                text = fruit.name,
                style = MaterialTheme.typography.titleLarge
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun FruitScreenPreview() {
    MaterialTheme {
        FruitContent(
            fruits = listOf(
                Fruit(
                    name = "Apple",
                    imageResId = R.drawable.apple
                ),
                Fruit(
                    name = "Banana",
                    imageResId = R.drawable.banana
                ),
                Fruit(
                    name = "Orange",
                    imageResId = R.drawable.orange
                )
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun FruitItemListPreview() {
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        FruitItem(
            Fruit(
                name = "Apple",
                imageResId = R.drawable.apple
            )
        )
    }
}
