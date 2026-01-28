package com.example.ud4_ejemplo3.modelo

data class JuegoUIState (
    val palabraActual: String = "",
    val isLetraIncorrecta: Boolean = false,
    val puntos: Int = 0,
    val ronda: Int = 1,
    val letrafallada: String = "",
    val isFinJuego: Boolean = false,
    val fallos: Int = 0,
    var letrasfalladas: MutableSet<String> = mutableSetOf()
)