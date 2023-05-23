package com.data.model.recipes

data class Step(
    val equipment: List<Equipment>,
    val ingredients: List<İngredient>,
    val length: Length?,
    val number: Int,
    val step: String
)