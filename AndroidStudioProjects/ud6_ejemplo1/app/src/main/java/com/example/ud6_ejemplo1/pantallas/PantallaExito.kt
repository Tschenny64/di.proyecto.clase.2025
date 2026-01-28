package com.example.ud6_ejemplo1.pantallas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ud6_ejemplo1.modelo.Respuesta

@Composable
fun PantallaExito(
    onBotonSiguientePulsado: (String) -> Unit,
    respuesta: Respuesta,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier
        .padding(top = 40.dp)) {
        items(respuesta.resultados) { planeta ->
            Box(modifier = Modifier.padding(8.dp)) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Button(onClick = { onBotonSiguientePulsado(planeta.nombre) }) {
                        Column {
                            Text(text = planeta.nombre)
                            Text(text = planeta.terreno)
                        }
                    }
                    HorizontalDivider()
                }
            }
        }
    }
}
