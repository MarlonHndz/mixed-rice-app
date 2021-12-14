package com.marlonhndz.domain.models

import java.io.Serializable

data class Product(
    val id: String,
    val name: String,
    val description: String,
    val imageURL: String,
    val type: ProductType,
    var isFavorite: Boolean,
    val amounts: List<Amount>
) : Serializable

data class Amount(
    val id: String,
    val price: Int,
    val weight: String,
    val servings: String
) : Serializable

enum class ProductType(val value: String) {
    Classic("classic"),
    Extra("extra"),
    Special("special");

    companion object {
        fun fromValue(value: String): ProductType = when (value) {
            "classic" -> Classic
            "extra" -> Extra
            "special" -> Special
            else -> throw IllegalArgumentException()
        }
    }
}
