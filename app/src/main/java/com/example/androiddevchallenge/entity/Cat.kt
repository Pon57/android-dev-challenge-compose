package com.example.androiddevchallenge.entity

class Cat(
    override val name: String,
    override val age: Int
) : Pet {
    val dummyCatsList: List<Cat> = listOf()
}