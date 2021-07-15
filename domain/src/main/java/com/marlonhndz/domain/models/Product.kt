package com.marlonhndz.domain.models

import java.io.Serializable

data class Product(
    val name: String,
    val description: String,
    val imageURL: String
) : Serializable
