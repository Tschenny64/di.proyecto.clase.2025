package com.example.examen_ikercatala.datos

import android.annotation.SuppressLint
import com.example.examen_ikercatala.R
import com.example.examen_ikercatala.modelo.Tarjeta

class Datos {
    @SuppressLint("ResourceType")
    fun cargarBanderas(): List<Tarjeta> = listOf(
        Tarjeta( R.string.nombre1, R.string.rol1, R.drawable.alumno),
        Tarjeta( R.string.nombre2, R.string.rol2, R.drawable.profesor),
        Tarjeta( R.string.nombre3, R.string.rol3, R.drawable.alumno),
        Tarjeta( R.string.nombre4, R.string.rol4, R.drawable.profesor),
        Tarjeta( R.string.nombre5, R.string.rol5, R.drawable.alumno),
        Tarjeta( R.string.nombre6, R.string.rol6, R.drawable.profesor),
        Tarjeta( R.string.nombre7, R.string.rol7, R.drawable.alumno),
        Tarjeta( R.string.nombre8, R.string.rol8, R.drawable.profesor)
    )
}