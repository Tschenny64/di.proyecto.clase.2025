package com.example.ud6_ejemplo1.pantallas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ud6_ejemplo1.modelo.Respuesta

@Composable
fun PantallaPeliculas(
    nombrePlaneta: String?,
    respuesta: Respuesta,
    modifier: Modifier = Modifier
        .padding(top = 50.dp)
) {
    val planeta = respuesta.resultados.find { it.nombre == nombrePlaneta }

    if (planeta != null) {
        LazyColumn(modifier = modifier) {
            items(planeta.peliculas) { pelicula ->
                Text(text = pelicula, modifier = Modifier.padding(8.dp))
            }
        }
    } else {
        Text("No se encontró el planeta", modifier = modifier.padding(16.dp))
    }
}
