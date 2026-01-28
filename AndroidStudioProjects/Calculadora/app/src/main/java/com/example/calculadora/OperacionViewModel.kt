package com.example.calculadora.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.room.util.copy
import com.example.calculadora.modelo.OperacionUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OperacionViewModel : ViewModel() {
    private val _operacionUItate = MutableStateFlow(OperacionUIState())

    val operacionUIState: StateFlow<OperacionUIState> = _operacionUItate.asStateFlow()

    var respuestaNumero1 by mutableStateOf("")
        private set

    var respuestaNumero2 by mutableStateOf("")
        private set

    var respuestaNumero3 by mutableStateOf("")
        private set

    fun actualizarNumero1(num: String) {
        respuestaNumero1 = num

        _operacionUItate.update { estadoActual ->
            estadoActual.copy(
                numero1 = respuestaNumero1
            )
        }

        calcular()

    }

    fun actualizarNumero2(num: String) {
        respuestaNumero2 = num

        _operacionUItate.update { estadoActual ->
            estadoActual.copy (
                numero2 = respuestaNumero2
            )
        }

        calcular()
    }

    fun actualizarNumero3(num: String) {
        respuestaNumero3 = num

        _operacionUItate.update { estadoActual ->
            estadoActual.copy(
                numero3 = respuestaNumero3
            )
        }

        calcular()

    }

    private fun calcular() {
        _operacionUItate.update { estadoActual ->
            val num1 = estadoActual.numero1.toIntOrNull() ?: 0
            val num2 = estadoActual.numero2.toIntOrNull() ?: 0
            val num3 = estadoActual.numero3.toIntOrNull() ?:0

            estadoActual.copy(
                resultadoSuma = (num1 + num2 + num3).toString(),
                resultadoResta = (num1 - num2 - num3).toString()
            )
        }
    }
}