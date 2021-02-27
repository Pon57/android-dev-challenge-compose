/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.entity.Cat
import com.example.androiddevchallenge.entity.Dog
import com.example.androiddevchallenge.entity.Pet

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
                                Modifier.fillMaxWidth().padding(4.dp)
                            ) {
                                when (pet) {
                                    is Dog -> Text(text = "\uD83D\uDC36")
                                    is Cat -> Text(text = "\uD83D\uDE40")
                                }
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
fun PetDetail(petIndex: Int, modifier: Modifier = Modifier) {
    Surface(color = MaterialTheme.colors.background) {
        val pet = dummyPetsList[petIndex]
        Column {
            when (pet) {
                is Dog -> Text(
                    text = "\uD83D\uDC36",
                    style = TextStyle(fontSize = 50.sp)
                )
                is Cat -> Text(
                    text = "\uD83D\uDE40",
                    style = TextStyle(fontSize = 50.sp)
                )
            }
            Text(
                text = "name: ${pet.name} age: ${pet.age}",
                modifier = modifier.padding(4.dp)
            )
        }
    }
}

@Composable
fun PreviewPetDetail(petIndex: Int) {
    PetDetail(petIndex = petIndex)
}
