package com.example.ud6_ejemplo1

import android.R.attr.contentDescription
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ud6_ejemplo1.modelo.Respuesta
import com.example.ud6_ejemplo1.pantallas.PantallaExito
import com.example.ud6_ejemplo1.pantallas.PantallaPeliculas
import com.example.ud6_ejemplo1.ui.StarwarsUIState
import com.example.ud6_ejemplo1.ui.StarwarsViewModel
import com.example.ud6_ejemplo1.ui.theme.Ud6_ejemplo1Theme

enum class Pantallas {
    Exito,
    Peliculas
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ud6_ejemplo1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaDatos(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaDatos(
    modifier: Modifier = Modifier,
    viewModel: StarwarsViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val starwarsUIState = viewModel.starwarsUIState

    when (starwarsUIState) {
        is StarwarsUIState.Cargando -> PantallaCargando(modifier = modifier.fillMaxSize())
        is StarwarsUIState.Error -> PantallaError (modifier = modifier.fillMaxWidth())
        is StarwarsUIState.Exito -> {
            NavHost(
                navController = navController,
                startDestination = Pantallas.Exito.name
            ) {
                composable(Pantallas.Exito.name) {
                    PantallaExito(
                        respuesta = starwarsUIState.respuesta,
                        onBotonSiguientePulsado = { nombrePlaneta ->
                            navController.navigate(Pantallas.Peliculas.name)
                        }
                    )
                }
                composable(Pantallas.Peliculas.name) { backStackEntry ->
                    val nombrePlaneta = backStackEntry.arguments?.getString("nombrePlaneta")
                    PantallaPeliculas(
                        nombrePlaneta = nombrePlaneta,
                        respuesta = starwarsUIState.respuesta
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaCargando(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.cargando),
        contentDescription = stringResource(R.string.cargando)
    )
}

@Composable
fun PantallaError(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.error),
        contentDescription = stringResource(R.string.error_de_conexion)
    )
}
