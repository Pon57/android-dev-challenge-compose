package com.example.androiddevchallenge.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.App
import com.example.androiddevchallenge.entity.Cat
import com.example.androiddevchallenge.entity.Dog
import com.example.androiddevchallenge.entity.Pet
import com.example.androiddevchallenge.ui.theme.MyTheme

val dummyPetsList: List<Pet> = listOf(
    Dog("poti", 2),
    Cat("tama", 3),
    Dog("wan", 2),
    Cat("nya", 3)
)

@Composable
fun PetsList(navController: NavController, pets: List<Pet>, modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = modifier) {
            LazyColumn(Modifier.fillMaxWidth()) {
                pets.forEachIndexed { index, pet ->
                    item {
                        Row {
                            Button(
                                onClick = {
                                    navController.navigate("pet/$index")
                                },
                                Modifier.fillMaxWidth()
                            ) {
                                when (pet) {
                                    is Dog -> Text(text = "\uD83D\uDC36")
                                    is Cat -> Text(text = "\uD83D\uDE40")
                                }// Icons.Filled.Star
                                Text(text = "name: ${pet.name} age: ${pet.age}")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PreviewPetsList(navController: NavController) {
    PetsList(navController, pets = dummyPetsList)
}

@Composable
fun PetDetail(navController: NavController, petIndex: Int, modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colors.background) {
        val pet = dummyPetsList[petIndex]
        Text(text = "name: ${pet.name} age: ${pet.age}")
    }
}

@Composable
fun PreviewPetDetail(navController: NavController, petIndex: Int) {
    PetDetail(navController, petIndex = petIndex)
}