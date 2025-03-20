package com.example.up.Domain.models

import kotlinx.serialization.Serializable

@Serializable
data class Category(
    val id: String,
    val title: String
)
