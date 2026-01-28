package com.example.ud6_ejemplo1.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ud6_ejemplo1.conexion.Api
import com.example.ud6_ejemplo1.modelo.Respuesta
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed interface StarwarsUIState {
    data class Exito(val respuesta: Respuesta) : StarwarsUIState
    object Error : StarwarsUIState
    object Cargando : StarwarsUIState
}

class StarwarsViewModel : ViewModel() {
    var starwarsUIState: StarwarsUIState by mutableStateOf(StarwarsUIState.Cargando)
        private set

    init {
        obtenerPlaneta()
    }

    fun obtenerPlaneta() {
        viewModelScope.launch {
            starwarsUIState = StarwarsUIState.Cargando
            starwarsUIState = try {
                val listaPlanetas = Api.servicioRetrofit.obtenerPlaneta()
                StarwarsUIState.Exito(listaPlanetas)
            } catch (e: IOException) {
                StarwarsUIState.Error
            } catch (e: HttpException) {
                StarwarsUIState.Error
            }
        }
    }
}