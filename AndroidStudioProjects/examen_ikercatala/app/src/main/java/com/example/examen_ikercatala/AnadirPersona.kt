package com.example.examen_ikercatala

import android.util.Printer
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun AnadirPersona() {
    var nombre by remember { mutableStateOf("") }
    var nia by remember { mutableStateOf("") }
    var tiporol by remember { mutableStateOf("Alumno") }
    var tipocurso by remember { mutableStateOf("Primero") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(46.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.titulo_anadirpersona),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.padding(30.dp))
        Text(
            text = stringResource(R.string.codigo),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.padding(10.dp))
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it},
            label = { Text(stringResource(R.string.nombre))},
            singleLine = true,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        Text(
            text = stringResource(R.string.rol),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.padding(10.dp))
        Row {
        Image(
            painter = painterResource(id = R.drawable.alumno),
            contentDescription = "",
            modifier = Modifier
                .size(130.dp)
                .padding(16.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.profesor),
            contentDescription = "",
            modifier = Modifier
                .size(130.dp)
                .padding( 16.dp)
        )
        }
        Row(    horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = tiporol == "Alumno", onClick = { tiporol = "Alumno" })
            Text(text = stringResource(R.string.alumno))
            RadioButton(selected = tiporol == "Profesor", onClick = { tiporol = "Profesor" })
            Text(text = stringResource(R.string.profesor))
        }
        if (tiporol == "Profesor") {
            Row(modifier = Modifier.padding(20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(modifier = Modifier.padding(16.dp), text = stringResource(R.string.tutor),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary)

                SwitchMinimalExample()

            }
            Row(modifier = Modifier.padding(20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = stringResource(R.string.curso),
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary)
                Column {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = tipocurso == "Primero",
                            onClick = { tipocurso = "Primero" })
                        Text(text = stringResource(R.string.primero))
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = tipocurso == "Segundo",
                            onClick = { tipocurso = "Segundo" })
                        Text(text = stringResource(R.string.segundo))

                    }
                }

            }


        }
        if (tiporol == "Alumno") {

            OutlinedTextField(
                value = nia,
                onValueChange = { nia = it},
                label = { Text(stringResource(R.string.nia))},
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth().padding(bottom = 28.dp).padding(top = 50.dp) ,

            )

Row(
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
) {
    Text(text = stringResource(R.string.curso),
        style = MaterialTheme.typography.headlineLarge,
        color = MaterialTheme.colorScheme.primary)
Column {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
    RadioButton(
        selected = tipocurso == "Primero",
        onClick = { tipocurso = "Primero" })
    Text(text = stringResource(R.string.primero))
    }
Row(
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
) {
    RadioButton(
        selected = tipocurso == "Segundo",
        onClick = { tipocurso = "Segundo" })
    Text(text = stringResource(R.string.segundo))
}
}

}




        }
        Spacer(modifier = Modifier.padding(top = 80.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                // SE GUARDARAN LOS DATOS INDICADOS
            }) { Text(stringResource(R.string.anadir)) }

            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {
                // SE CANCELARA

            }) { Text(stringResource(R.string.cancelar)) }
        }
    }
}

@Composable
fun SwitchMinimalExample() {
    var checked by remember { mutableStateOf(false)}
    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )
}