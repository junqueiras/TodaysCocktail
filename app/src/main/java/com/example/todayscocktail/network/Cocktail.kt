package com.example.todayscocktail.network

import com.squareup.moshi.Json


data class Cocktail(
    @Json()
    val id: Int,
    val name: String,
    val thumbUrl: String
)
