package com.example.myapplication

import java.io.Serializable

data class Recipes(val title: String, val ingredients: String, val steps: String, val imageUrl: String) : Serializable
