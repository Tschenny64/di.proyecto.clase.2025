package com.example.ejercicio3.datos

import android.annotation.SuppressLint
import com.example.ejercicio3.R
import com.example.ejercicio3.modelo.Bandera

class Datos {
    @SuppressLint("ResourceType")
    fun cargarBanderas(): List<Bandera> = listOf(
        Bandera( R.string.nombre1, R.string.dni1, R.drawable.alumno),
        Bandera( R.string.nombre2, R.string.dni2, R.drawable.profesor)
    )
}