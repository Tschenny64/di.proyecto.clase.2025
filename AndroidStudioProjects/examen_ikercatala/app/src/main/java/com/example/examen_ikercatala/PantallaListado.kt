package com.example.examen_ikercatala

import android.R.attr.horizontalDivider
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.examen_ikercatala.datos.Datos
import com.example.examen_ikercatala.modelo.Tarjeta
import kotlin.toString

@Composable
fun PantallaListado(modifier: Modifier = Modifier) {
    ListaBanderas(
        lista = Datos().cargarBanderas(),
        modifier = modifier
    )
    Text(text = "")
}

@Composable
fun ListaBanderas(lista: List<Tarjeta>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(lista) { bandera ->

            ItemBandera(

                bandera = bandera,
                onItemClick = { //
                }
            )
        }
    }
}


@Composable
fun ItemBandera(bandera: Tarjeta, onItemClick: (Tarjeta) -> Unit) {
    TarjetaBandera(
        bandera = bandera,
        modifier = Modifier.clickable {
            onItemClick(bandera)
        }.padding(8.dp)
    )
}

@Composable
fun TarjetaBandera(bandera: Tarjeta, modifier: Modifier = Modifier) {

    Card(modifier = modifier) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.width(150.dp),
                    painter = painterResource(bandera.imagenResId),
                    contentDescription = stringResource(
                        R.string.nombre2,
                        stringResource(bandera.nombreResId),
                        stringResource(bandera.nombreResId)
                    )
                )
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = stringResource(
                            R.string.nombre2,
                            stringResource(bandera.nombreResId),
                            stringResource(bandera.nombreResId)
                        ),
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = stringResource(bandera.rolResId),
                        style = MaterialTheme.typography.headlineMedium,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}
