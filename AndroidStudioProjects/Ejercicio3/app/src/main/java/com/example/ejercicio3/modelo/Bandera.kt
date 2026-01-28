package com.example.ejercicio3.modelo

import android.content.res.Resources
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Bandera(
    @StringRes val nombreResId: Int,
    @StringRes val dniResId: Int,
    @DrawableRes val imagenResId: Int
)
