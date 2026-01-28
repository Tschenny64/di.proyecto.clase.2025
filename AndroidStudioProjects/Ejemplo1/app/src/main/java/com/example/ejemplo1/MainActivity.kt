package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                         EjemploImagen(
                             modifier = Modifier.padding(innerPadding)
                                 .fillMaxSize()
                                 .wrapContentSize(Alignment.Center)
                         )
                    }
                }
            }
        }
    }
@Composable
fun EjemploImagen(modifier: Modifier = Modifier) {
    ImagenRandomBoton(modifier= modifier)
}

@Composable
fun ImagenRandomBoton(modifier: Modifier = Modifier) {
    // Para poder cambiar el valor de la variable aleatoria debemos guardar su estado.
    var result by remember { mutableStateOf(1) }
    // Dependiendo del valor de la variable aleatoria cargaremos una imagen u otra.
    val imagen = when(result) {
        1 -> R.drawable.bandera1
        2 -> R.drawable.bandera2
        3 -> R.drawable.bandera3
        4 -> R.drawable.bandera4
        else -> R.drawable.bandera5
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imagen),
            contentDescription = stringResource(R.string.bandera, result)
        )
        Button(
            onClick = {result = (1..5).random() }
        ) {
            Text(text = stringResource(R.string.tira))
        }
    }
}