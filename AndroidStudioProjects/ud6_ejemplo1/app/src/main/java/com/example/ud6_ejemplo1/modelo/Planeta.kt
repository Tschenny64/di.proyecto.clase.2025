package com.example.ud6_ejemplo1.modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Planeta(
    @SerialName(value = "name")
    val nombre: String,
    @SerialName(value = "terrain")
    val terreno: String,
    @SerialName(value = "films")
    val peliculas: Array<String>
)