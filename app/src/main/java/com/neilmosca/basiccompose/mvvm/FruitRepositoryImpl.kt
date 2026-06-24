package com.neilmosca.basiccompose.mvvm

import com.neilmosca.basiccompose.R

class FruitRepositoryImpl: FruitRepository {
    override fun getAllFruits(): List<Fruit> {
        return listOf(
            Fruit(
                name = "Apple",
                imageResId = R.drawable.apple
            ),
            Fruit(
                name = "Banana",
                imageResId = R.drawable.banana
            ),
            Fruit(
                name = "Cherry",
                imageResId = R.drawable.cherry
            ),
            Fruit(
                name = "Dragonfruit",
                imageResId = R.drawable.dragon_fruit
            ),
            Fruit(
                name = "Grapes",
                imageResId = R.drawable.grapes
            ),
            Fruit(
                name = "Oranges",
                imageResId = R.drawable.orange
            ),
            Fruit(
                name = "Strawberry",
                imageResId = R.drawable.strawberry
            ),
            Fruit(
                name = "Pineapple",
                imageResId = R.drawable.pineapple
            ),
            Fruit(
                name = "Pear",
                imageResId = R.drawable.pear
            )
        )
    }
}